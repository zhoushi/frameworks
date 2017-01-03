package com.zhou.Aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/12/15.
 */
public class AioServerDemo {

    private static CountDownLatch latch;

    public static void startServerr()throws Exception{
        final AsynchronousServerSocketChannel asyServerSocketChannel = AsynchronousServerSocketChannel.open();

        asyServerSocketChannel.bind(new InetSocketAddress(8999));
        latch = new CountDownLatch(1);

    }
}
