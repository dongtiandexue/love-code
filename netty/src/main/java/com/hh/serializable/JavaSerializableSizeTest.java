package com.hh.serializable;

import com.hh.pojo.UserInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Description: TODO
 * @Author: hh
 * @date 2020/11/8
 */
public class JavaSerializableSizeTest {

    public static void main(String[] args) throws IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.buildUserId(100).buildUsername("Welcome to Netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(userInfo);
        os.flush();
        os.close();

        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is : " + b.length);
        bos.close();

        System.out.println("---------------------------");
        System.out.println("The byte array serializable length is : " + userInfo.codeC().length);
    }
}
