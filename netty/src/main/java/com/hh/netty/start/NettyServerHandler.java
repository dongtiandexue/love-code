package com.hh.netty.start;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @Description: Netty 服务端管道处理器
 * 说明：
 * 1、自定义一个 handler 需要继承 netty规定好的某个 HandlerAdapter
 * 2、这时我们自定义的handler，才能称之为handler
 * @Author: hh
 * @date 2020/10/25
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送的信息
     * @param ctx 上下文对象，含有 pipeline(管道)、channel(通道)、连接地址
     * @param msg 就是客户端发送的数据，以对象的形式传递
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx = " + ctx);
        //将msg转成一个ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息时：" + buf.toString(Charset.forName("utf-8")));
        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
    }

    /**
     * 读取数据完毕后，触发的动作
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // writeAndFlush 是 write + flush,将数据写入到缓存，并刷新
        // 正常来说，需要对发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~".toCharArray(), CharsetUtil.UTF_8));
    }

    /**
     * 发送异常后，触发的动作
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("服务端发送异常，异常信息: " + cause.getMessage());
        ctx.close();
    }
}
