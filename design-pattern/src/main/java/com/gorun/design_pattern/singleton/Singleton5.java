package com.gorun.design_pattern.singleton;

/**
 * @Version: V1.0.0
 * @Description: 饿汉式加载
 * 定义一个私有的内部类，在第一次用这个嵌套类时，会创建一个实例。
 * 而类型为SingletonHolder的类，只有在Singleton.getInstance()中调用，
 * 由于私有的属性，他人无法使用SingleHolder，不调用Singleton.getInstance()就不会创建实例。
 * @Author: gorun
 * @date 2020/8/1
 */
public class Singleton5 {

    private static Singleton5 instance = new Singleton5();

    private Singleton5() {
    }

    private static class SingletonHolder {
        private final static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }
}
