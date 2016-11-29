package com.zhou.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/11/29.
 */
public class TimeAsycServer {

    public static void main(String[] args)throws IOException{
        int port = 8080;
        if (args != null && args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("the time serrver is start in port: "+port);
            Socket socket = null;

            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);
            while (true){
                //服务接收
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (server != null){
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
