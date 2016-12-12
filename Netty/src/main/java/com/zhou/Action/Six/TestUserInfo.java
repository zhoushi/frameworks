package com.zhou.Action.Six;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2016/12/12.
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();

        info.buildUserID(100).buildUserName("Welcome to Netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);

        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();

        String s = new String(b);

        System.out.println("The jdk serializable length is:"+b.length);
        bos.close();

        System.out.println("The byte array serializable length is:"+info.codeC().length);
    }
}
