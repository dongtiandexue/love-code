package com.hh.netty.start;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Description: Netty 服务端
 * @Author: hh
 * @date 2020/10/25
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        // 1、创建 BoosGroup 和 WorkerGroup
        // BossGroup 用于处理客户端连接请求，真实的客户端业务处理，会交给 WorkerGroup 处理
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //2、创建服务端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {// 创建一个通道初始对象(匿名内部类)
                        //向pipeline中添加处理器
                        protected void initChannel(SocketChannel sc) throws Exception {
                            ChannelPipeline pipeline = sc.pipeline();
                            pipeline.addLast(new NettyServerHandler());
                        }
                    });

            System.out.println("服务器准备完成。。。。");
            // 3、绑定一个端口并且同步处理，生成一个 ChannelFuture 对象
            // 绑定端口，并启动服务器
            ChannelFuture channelFuture = bootstrap.bind(6666).sync();
            // 4、对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        }finally {
            // 发生异常关闭 NioEventLoopGroup
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}




























