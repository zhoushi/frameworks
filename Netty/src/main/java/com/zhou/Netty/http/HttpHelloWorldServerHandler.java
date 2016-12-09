package com.zhou.Netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.AsciiString;

/**
 * Created by Administrator on 2016/12/8.
 */
public class HttpHelloWorldServerHandler extends ChannelInboundHandlerAdapter{
    private static final byte[] CONTENT = {'H','e','l','l','l'};
    private static final AsciiString CONTENT_TYPE = new AsciiString("Content-Type");
    private static final AsciiString CONTENT_LENGTH = new AsciiString("Content-Length");
    private static final AsciiString CONNECTION = new AsciiString("Connection");
    private static final AsciiString KEEP_ALIVE = new AsciiString("keep-alive");

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest){
            HttpRequest req = (HttpRequest) msg;

            if (HttpUtil.is100ContinueExpected(req)){
//                ctx.write(new DefaultFullHttpResponse(HTTP_1_1,CONTENT))
            }
        }
    }
}
