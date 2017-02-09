package com.zhou.executor;

import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/8.
 */
public class LoggerThread extends Thread {

    private final PrintWriter writer;
    LoggerThread(PrintWriter writer){
        this.writer = writer;
    }
    @Override
    public void run() {

        try {
            while (true)
                writer.println();
        }finally {
            writer.close();
        }
    }
}
