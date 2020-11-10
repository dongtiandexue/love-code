package com.hh.pojo;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @Description: TODO
 * @Author: hh
 * @date 2020/11/8
 */
public class UserInfo implements Serializable {

    private String username;
    private int userId;

    public UserInfo buildUsername(String username){
        this.username = username;
        return this;
    }

    public UserInfo buildUserId(int userId){
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte[] codeC(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] value = this.getUsername().getBytes();
        byteBuffer.putInt(value.length);
        byteBuffer.put(value);
        byteBuffer.putInt(this.getUserId());
        byteBuffer.flip();
        value = null;
        byte[] result = new byte[byteBuffer.remaining()];
        byteBuffer.get(result);
        return result;
    }

    public byte[] codeC(ByteBuffer byteBuffer){
        byteBuffer.clear();
        byte[] value = this.getUsername().getBytes();
        byteBuffer.putInt(value.length);
        byteBuffer.put(value);
        byteBuffer.putInt(this.getUserId());
        byteBuffer.flip();
        value = null;
        byte[] result = new byte[byteBuffer.remaining()];
        byteBuffer.get(result);
        return result;
    }
}
