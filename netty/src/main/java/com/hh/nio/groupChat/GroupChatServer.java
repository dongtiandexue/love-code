package com.hh.nio.groupChat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: 群聊系统服务端
 * @Author: hh
 * @date 2020/10/21
 */
public class GroupChatServer {


    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6666;

    public GroupChatServer() {

        try {
            //得到选择器
            selector = Selector.open();
            //得到ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            // 设置非阻塞模式
            listenChannel.configureBlocking(false);
            // 将channel注册到selector上
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            while (true) {
                int count = this.selector.select();
                if (count > 0) {
                    //遍历得到SelectionKeys集合
                    Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        // 取出 selectionKey
                        SelectionKey selectionKey = iterator.next();
                        // 监听到accept事件
                        if (selectionKey.isAcceptable()) {
                            SocketChannel socketChannel = this.listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(this.selector, SelectionKey.OP_READ);
                            // 提示
                            System.out.println(socketChannel.getRemoteAddress() + " 上线");

                        }

                        // 监听到read事件
                        if (selectionKey.isReadable()) {
                            // 处理读请求
                            readData(selectionKey);
                        }

                        // 将当前key删除，防止重复处理
                        iterator.remove();


                    }
                } else {
                    System.out.println("服务端等待2秒，无任何连接。。。");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取客户端信息
     *
     * @param selectionKey
     */
    public void readData(SelectionKey selectionKey) {
        // 定义一个socketChannel
        SocketChannel channel = null;
        try {
            // selectionKey 取到关联的channel
            channel = (SocketChannel) selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            // 根据count值做处理
            if (count > 0) {
                String msg = new java.lang.String(buffer.array());
                // 获取客户端消息
                System.out.println("from 客户端：" + msg);
                // 转发消息
                sendToOtherClient(msg, channel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println(channel.getRemoteAddress() + " 下线了");
                // 取消注册
                selectionKey.cancel();
                // 关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 转发消息到其他客户端
     *
     * @param msg
     * @param self
     * @throws IOException
     */
    public void sendToOtherClient(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中。。。");
        for (SelectionKey selectionKey : selector.keys()) {
            Channel targetChannel =  selectionKey.channel();
            // 排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                //将msg存储到buffer,并通过channel转发
                dest.write(ByteBuffer.wrap(msg.getBytes()));
            }

        }
    }


    public static void main(String[] args) {
        GroupChatServer server = new GroupChatServer();
        server.listen();
    }
}
