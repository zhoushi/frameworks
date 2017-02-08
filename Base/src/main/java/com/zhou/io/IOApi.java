package com.zhou.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/20.
 */
public class IOApi {

    public static void main(String[] args) throws IOException {
//        File source = new File(getClass().getResource("/iotest.txt").getFile());

        System.out.println("aa");
    }

    public void getFile() throws IOException {
        File source = new File(getClass().getResource("/iotest.txt").getFile());
        File destination = File.createTempFile("test","txt");
        BufferedReader reader = new BufferedReader(new FileReader(source));
        long count = 0;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination));

            try {
                String line = null;
                while ((line = reader.readLine())!=null){
                    count++;
                    writer.append(line).append('\n');
                }
                writer.close();
            }catch (IOException e){
                writer.close();
                destination.delete();
            }
        }finally {
            reader.close();
        }

        System.out.println(count);
    }
}
