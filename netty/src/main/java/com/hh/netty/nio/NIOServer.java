package com.hh.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: NIO服务端 非阻塞
 * @Author: hh
 * @date 2020/10/18
 */
public class NIOServer {

    private static final int port = 6666;

    private static final long timeout = 1000L;

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        Selector selector = Selector.open();

        // 绑定一个端口 6666，在服务端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 将ServerSocketChannel 注册到 Selector, 关联 连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 循环等待客户端连接
        while (true) {
            if (selector.select(timeout) == 0) {
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }

            // 如果有事件发生，获取到相关的 selectionKeys 集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            while (selectionKeyIterator.hasNext()) {
                // 获取到 SelectionKey
                SelectionKey selectionKey = selectionKeyIterator.next();
                // 根据获取到的事件类型，做相应的处理
                if (selectionKey.isAcceptable()) {
                    // 如果是连接事件，产生一个新的socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 将 SocketChannel 注册到 Selector，关注事件为 读事件
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (selectionKey.isReadable()) {
                    // 如果是一个读取事件
                    // 通过 SelectionKey 反向获取到，SocketChannel
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    socketChannel.read(buffer);
                    System.out.println("来自客户端：" + new String(buffer.array()));
                    buffer.clear();
                }

                // 手动从集合中移除当前 SelectionKey，防止重复操作
                selectionKeyIterator.remove();
            }

        }
    }
}
