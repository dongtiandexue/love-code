package com.hh.netty.start;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Description: Netty 客户端
 * @Author: hh
 * @date 2020/10/25
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        // 1、客户端需要一个事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            // 2、创建客户端启动对象,并设置相关参数
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)//设置线程组
                    .channel(NioSocketChannel.class)//设置客户端通道实现类
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel sc) throws Exception {
                            ChannelPipeline pipeline = sc.pipeline();
                            pipeline.addLast(new NettyClientHandler());//加入自定义处理器
                        }
                    });

            System.out.println("客户端准备完成。。。");
            //3、启动客户端连接服务器端
            // ChannelFuture 还要继续分析，涉及到 Netty 的异步模型
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666).sync();
            // 4、对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();

        } finally {
            // 优雅的关闭
            eventExecutors.shutdownGracefully();
        }

    }
}
