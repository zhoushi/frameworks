package com.zhou.Netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLContext;

/**
 * Created by Administrator on 2016/12/8.
 */
public class HttpHelloWorldServer {

    static final boolean SSL = System.getProperty("ssl")!=null;
    static final int PORT = Integer.parseInt(System.getProperty("port",SSL?"8443":"8080"));

    public static void main(String...args)throws Exception{
        final SslContext sslContext;
        if (SSL){
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslContext = SslContextBuilder.forServer(ssc.certificate(),ssc.privateKey()).build();
        }else {
            sslContext = null;
        }

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.option(bossGroup,workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .handler(new LoggingHandler(LogLevel.INFO))
//                    .childHandler(new HttpHellWorldServerInitializer(sslContext));
//
//            Channel ch = b.bind(PORT).sync().channel();
//
//            System.err.println();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
