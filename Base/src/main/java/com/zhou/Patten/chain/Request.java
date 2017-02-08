package com.zhou.Patten.chain;

import java.util.Objects;

/**
 * Created by Administrator on 2017/1/18.
 */
public class Request {
    /**
     * 请求类型，
     */
    private final RequestType requestType;

    private final String requestDescription;

    private boolean handled;

    public Request(final RequestType requestType,final String requestDescription){
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(requestDescription);
    }

    public String getRequestDescription(){
        return requestDescription;
    }

    public RequestType getRequestType(){
        return requestType;
    }

    public void markHandled(){
        this.handled = true;
    }

    public boolean isHandled(){
        return this.handled;
    }

    @Override
    public String toString() {
        return getRequestDescription();
    }
}
