package com.hh.nio.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Description: 群聊系统 客户端
 * @Author: hh
 * @date 2020/10/21
 */
public class GroupChatClient {

    private Selector selector;
    private SocketChannel socketChannel;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6666;
    private String username;

    public GroupChatClient() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString();
            System.out.println(username + " is ok ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendInfo(String info) {
        info = username + " 说: " + info;
        try {
            ByteBuffer byteBuffer = ByteBuffer.wrap(info.getBytes());
            this.socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInfo() {

        try {
            int count = selector.select();
            if (count > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        // 根据count值做处理
                        if (channel.read(buffer) > 0) {
                            String msg = new String(buffer.array());
                            // 获取客户端消息
                            System.out.println(msg.trim());
                        }
                    }
                    iterator.remove();
                }
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动客户端
        GroupChatClient client = new GroupChatClient();
        // 每隔3秒从服务器读取数据
        new Thread(()->{
            while (true){
                client.readInfo();
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

        // 接收键盘录入发送消息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
           String info =  scanner.nextLine();
           client.sendInfo(info);
        }
    }


}
