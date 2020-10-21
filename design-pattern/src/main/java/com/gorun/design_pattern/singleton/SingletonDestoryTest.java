package com.gorun.design_pattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @Version: V1.0.0
 * @Description: 模拟反射攻击和序列化攻击破坏单例场景
 * @Author: gorun
 * @date 2020/8/1
 */
public class SingletonDestoryTest implements Serializable {

    public static void main(String[] args) throws Exception {
        // 通过饿汉式获取单例对象
        SingletonDestoryTest instance = SingletonDestoryTest.getInstance();

        // 通过反射获取单例对象
        Class instanceClass = SingletonDestoryTest.class;
        Constructor constructor = instanceClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDestoryTest newInstance1 = (SingletonDestoryTest) constructor.newInstance();

        // 序列化到文件
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:\\file"));
        out.writeObject(instance);

        // 反序列化读取对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\file"));
        SingletonDestoryTest newInstance2 = (SingletonDestoryTest) in.readObject();

        System.out.println("单例模式创建的对象：" + instance);
        System.out.println("反射创建的对象：" + newInstance1);
        System.out.println("反序列化创建的对象：" + newInstance2);
        System.out.println("原对象与反射创建对象是否相等：" + (instance == newInstance1));
        System.out.println("原对象与反序列化创建对象是否相等：" + (instance == newInstance2));
    }

    private static SingletonDestoryTest instance = new SingletonDestoryTest();

    private SingletonDestoryTest() {
    }

    public static SingletonDestoryTest getInstance() {
        return instance;
    }
}
