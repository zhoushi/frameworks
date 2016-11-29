package com.zhou.BIO;

/**
 * Created by Administrator on 2016/11/29.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步阻塞式I/O创建的TimeServer源码分析
 */
public class TimeServer {

    public static void main(String...args) throws IOException {
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

            while (true){
                //服务接收
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
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
