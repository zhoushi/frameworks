package com.zhou.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/29.
 */

/**
 * 同步阻塞客户端
 */
public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            //输入流
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            //输出流
            out = new PrintWriter(this.socket.getOutputStream());

            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("the time server receive order:"+body);

                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
                out.println(currentTime);
            }
        }catch(Exception e){

            if (in!=null){
                try {
                    in.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if (out!=null){
                out.close();
                out = null;
            }

            if (this.socket!=null){
                try {
                    this.socket.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }

                this.socket = null;
            }
        }

    }
}
