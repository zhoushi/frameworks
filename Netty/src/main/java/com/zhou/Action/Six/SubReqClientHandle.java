package com.zhou.Action.Six;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Administrator on 2016/12/12.
 */
public class SubReqClientHandle extends ChannelHandlerAdapter {

    public SubReqClientHandle(){}

    public void channelActive(ChannelHandlerContext ctx){
        for (int i=0;i<10;i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReq subReq(int i){
       SubscribeReq req = new SubscribeReq();
        req.setAddress("南京市江宁区");
        req.setPhoneNumber("138******");
        req.setProductName("Netty");
        req.setSubReqID(i);
        req.setUserName("Lilinfeng");
        return req;
    }

    public void channelRead(ChannelHandlerContext ctx,Object msg){
        System.out.println("Receive server response:["+msg+"]");
    }




}
