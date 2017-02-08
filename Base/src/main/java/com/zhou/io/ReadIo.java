package com.zhou.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/19.
 */
public class ReadIo {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(new File("D:/io/tests.txt"));
        InputStreamReader streamReader = new InputStreamReader(inputStream);

        Reader  reader = new BufferedReader(streamReader);
        streamReader.read();

        System.out.println(streamReader.read());
    }
}
