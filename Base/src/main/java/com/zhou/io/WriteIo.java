package com.zhou.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/19.
 */
public class WriteIo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/io/tests.txt");
        //写入
        Writer writer = new FileWriter(file);

        FileOutputStream fos = new FileOutputStream(file);

        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        Writer bw = new BufferedWriter(osw);

        String[] arrs = {"a","b"};
        for (String arr:arrs){
            bw.write(arr+"\t\n");
        }
    }
}
