package com.gorun.design_pattern.singleton;

/**
 * @Version: V1.0.0
 * @Description: 利用枚举创建单例
 * (1)自由序列化。
 * (2)保证只有一个实例。
 * (3)线程安全。
 * @Author: gorun
 * @date 2020/8/1
 */
public enum Singleton6 {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Singleton6 getInstance() {
        return INSTANCE;
    }
}
