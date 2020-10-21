package com.gorun.design_pattern.singleton;

/**
 * @Version: V1.0.0
 * @Description: 饿汉式加载
 * 在初始化静态变量instance时候创建一个实例
 * @Author: gorun
 * @date 2020/8/1
 */
public class Singleton4 {

    private static Singleton4 instance = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return instance;
    }
}
