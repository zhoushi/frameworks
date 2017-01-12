package com.zhou.rpc.core;

import com.zhou.rpc.model.MessageRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by Administrator on 2017/1/4.
 * RPC客户端消息处理
 */
public class MessageSendProxy<T> implements InvocationHandler{

    private Class<T> cls;

    public MessageSendProxy(Class<T> cls){
        this.cls = cls;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MessageRequest request = new MessageRequest();
        request.setMessageId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setTypeParameters(method.getParameterTypes());
        request.setParametersVal(args);


        return null;
    }
}
