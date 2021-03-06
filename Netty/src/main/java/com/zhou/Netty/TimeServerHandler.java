package com.zhou.Netty;

/**
 * Created by Administrator on 2016/11/30.
 */


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;

import java.util.Date;

/**
 * 处理器
 */
public class TimeServerHandler extends SimpleChannelInboundHandler {

    public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception{
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];

        buf.readBytes(req);
        //转换成String
        String body = new String(req,"UTF-8");
        System.out.println("The time server receive order: "+body);

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }

    public void channelReadComplete(ChannelHandlerContext ctx)throws Exception{
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();
    }
}
