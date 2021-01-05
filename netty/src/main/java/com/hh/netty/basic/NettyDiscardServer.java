package com.hh.netty.basic;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyDiscardServer {

    private final int serverPort;

    ServerBootstrap b = new ServerBootstrap();

    public NettyDiscardServer(int port) {
        this.serverPort = port;
    }

    public void runServer() {
        // 创建反应器线程组
        NioEventLoopGroup bossLoopGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        try {
            //1、设置反应器线程组
            b.group(bossLoopGroup, workerLoopGroup);
            //2、设置nio类型的通道
            b.channel(NioServerSocketChannel.class);
            //3、设置监听端口
            b.localAddress(serverPort);
            //4、设置通道的参数
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            //5、装配子通道流水线
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                //有连接到达时会创建一个通道
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new NettyDiscardHandler());
                }
            });

            //6、开始绑定服务器
            //通过sync同步方法阻塞直到绑定成功
            ChannelFuture future = b.bind().sync();
            System.out.println("服务器启动成功，监听端口：" + future.channel().localAddress());

            //7、等待通道关闭的异步任务结束
            //服务器监听通道会一致等待通道关闭的异步任务结束
            ChannelFuture closeFuture = future.channel().closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //8、关闭EventLoopGroup
            //释放所有的资源包括创建的线程
            workerLoopGroup.shutdownGracefully();
            bossLoopGroup.shutdownGracefully();
        }



    }


    public static void main(String[] args) {
        new NettyDiscardServer(6666).runServer();
    }
}
