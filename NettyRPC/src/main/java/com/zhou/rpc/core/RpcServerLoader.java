package com.zhou.rpc.core;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by Administrator on 2017/1/4.
 * rpc服务器配置加载
 */
public class RpcServerLoader {
    private volatile static RpcServerLoader rpcServerLoader;
    private final static String DELIMITER = ":";

//    private RpcSerializeProtocol serializeProtocol = RpcSerializeProtocol.JDKSERIALIZE;

    private final static int parallel = Runtime.getRuntime().availableProcessors()*2;

    //netty nio 线程池
    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup(parallel);

}
