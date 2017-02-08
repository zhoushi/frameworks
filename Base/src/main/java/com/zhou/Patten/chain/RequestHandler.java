package com.zhou.Patten.chain;

/**
 * Created by Administrator on 2017/1/18.
 */
public abstract class RequestHandler {

    private RequestHandler next;

    public RequestHandler(RequestHandler next){
        this.next = next;
    }

    public void handleRequest(Request req){
        if (next!=null){
            next.handleRequest(req);
        }
    }

    protected void printHandling(Request req){
        System.out.println(this+"handling request \""+req+"\"");
    }

    public abstract String toString();
}
