package com.zhou.NIO;

/**
 * Created by Administrator on 2016/11/29.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * NIO服务端通信流程
 */
public class NIO {

    public static void main(String...args) throws IOException {
        int port =8080;
        //打开ServerSocketChannel,用于监听客户端的连接，它是所有客户端连接的父管道
        ServerSocketChannel acceptorSvr = ServerSocketChannel.open();

        //绑定监听端口，设置连接为非阻塞模式
        acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"),port));
        acceptorSvr.configureBlocking(false);

        //创建Reactor线程，创建多路复用器并启动线程
        Selector selector = Selector.open();
//        new Thread(new ReactorTask()).start;

//        SelectionKey key = acceptorSvr.register(selector,SelectionKey.OP_ACCEPT,ioHandler);
    }
}
