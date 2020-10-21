package com.hh.netty.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Description: NIO 非阻塞模型 客户端
 * @Author: hh
 * @date 2020/10/18
 */
public class NIOClient {

    private static final String host = "127.0.0.1";

    private static final int port = 6666;

    public static void main(String[] args) throws Exception {
        // 得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞模式
        socketChannel.configureBlocking(false);
        // 提供服务端的ip和端口
        InetSocketAddress address = new InetSocketAddress(host, port);

        if (!socketChannel.connect(address)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以进行其他工作。。。");
            }
        }

        String body;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符串,当输入end时退出");
        do {
            body = br.readLine();
            System.out.println("您输入的字符串是：" + body);
            ByteBuffer byteBuffer = ByteBuffer.wrap(body.getBytes());
            // 发送数据
            socketChannel.write(byteBuffer);
        } while (!body.equals("end"));
        System.out.println("您已退出");
    }

}
