package com.zhou.rpc.model;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/13.
 * RPC服务接口定义，服务接口实现绑定关系容器定义，提供给spring作为容器使用
 */
public class MessageKeyVal {

    private Map<String,Object> messageKeyVal;

    public Map<String, Object> getMessageKeyVal() {
        return messageKeyVal;
    }

    public void setMessageKeyVal(Map<String, Object> messageKeyVal) {
        this.messageKeyVal = messageKeyVal;
    }
}
