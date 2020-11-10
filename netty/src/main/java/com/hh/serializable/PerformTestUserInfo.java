package com.hh.serializable;

import com.hh.pojo.UserInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * @Description: TODO
 * @Author: hh
 * @date 2020/11/8
 */
public class PerformTestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.buildUserId(100).buildUsername("Welcome to Netty");

        int loop = 1000000;

        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(userInfo);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("The jdk serializable cost time is : " + (end - start));


        System.out.println("---------------------------");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            userInfo.codeC(byteBuffer);
        }
        end = System.currentTimeMillis();
        System.out.println("The byte array serializable cost time is : " + (end - start));
    }
}
