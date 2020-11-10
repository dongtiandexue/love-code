package com.hh.netty.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description: 基于 TCP 协议 Netty 服务端
 * @Author: hh
 * @date 2020/11/4
 */
public class NettyTcpServer {

    public void bind(int port) throws InterruptedException {
        //1、配置bossGroup和workerGroup线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //2、创建ServerBootStrap
            ServerBootstrap bootstrap = new ServerBootstrap();

            //3、配置ServerBootStrap
            //3.1、关联 bossGroup 和 workerGroup
            //3.2、设置 NioServerSocketChannel
            //3.3、关联ChannelOption
            //3.4、设置处理器handler
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(null);
                        }
                    });

            //4、绑定监听端口，同步等待成功
            ChannelFuture channelFuture = bootstrap.bind(port).sync();

            //5、等待服务端监听端口关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            //6、优雅退出，释放线程组资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
