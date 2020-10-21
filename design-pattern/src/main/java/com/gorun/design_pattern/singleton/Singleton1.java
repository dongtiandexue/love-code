package com.gorun.design_pattern.singleton;

/**
 * @Version: V1.0.0
 * @Description: 懒汉式加载 只适合单线程环境
 * @Author: gorun
 * @date 2020/8/1
 */
public class Singleton1 {

    private static Singleton1 instance = null;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
