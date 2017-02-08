package com.zhou.Patten.chain;

/**
 * Created by Administrator on 2017/1/18.
 */
public class OrcSoldier extends RequestHandler {

    public OrcSoldier(RequestHandler handler){
        super(handler);
    }
    @Override
    public String toString() {
        return "Orc soldier";
    }

    public void handleRequest(Request req){
        if (req.getRequestType().equals(RequestType.COLLECT_TAX)){
            printHandling(req);
            req.markHandled();
        }else {
            super.handleRequest(req);
        }
    }
}
