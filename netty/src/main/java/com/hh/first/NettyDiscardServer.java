package com.hh.first;

import com.hh.netty.basic.NettyDiscardHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ReferenceCountUtil;

/**
 * @author huawei
 * @desc
 * @email huawei_code@163.com
 * @date 2021/1/19
 */
public class NettyDiscardServer {

    public static void main(String[] args) throws InterruptedException {
        // 1、创建反应器线程组
        NioEventLoopGroup bossLoopGroup = new NioEventLoopGroup();
        NioEventLoopGroup workLoopGroup = new NioEventLoopGroup();

        try {
            // 2、设置反应器线程组
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossLoopGroup, workLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(9999)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // 有连接到达时会创建一个通道
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyDiscardHandler());
                        }
                    });
            // 开始绑定服务器
            // 通过调用sync同步方法阻塞直到绑定成功
            ChannelFuture future = bootstrap.bind().sync();
            System.out.println("服务器启动成功，监听端口：" + future.channel().localAddress());
            // 等待通道关闭的异步任务结束
            // 服务监听通道会一直等待通道关闭的异步任务结束
            ChannelFuture closeFuture = future.channel().closeFuture();
            closeFuture.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            bossLoopGroup.shutdownGracefully();
            workLoopGroup.shutdownGracefully();
        }

    }

    public static class NettyDiscardHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

            try {
                ByteBuf in = (ByteBuf) msg;
                while (in.isReadable()) {
                    System.out.println("接收到客户端发送的消息：" + in.readByte());
                }
                System.out.println();
            } finally {
                ReferenceCountUtil.release(msg);
            }
        }
    }
}
