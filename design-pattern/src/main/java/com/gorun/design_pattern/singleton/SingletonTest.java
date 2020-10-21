package com.gorun.design_pattern.singleton;

/**
 * @Version: V1.0.0
 * @Description: 单例设计模式测试类
 * @Author: gorun
 * @date 2020/8/1
 */
public class SingletonTest {

    public static void main(String[] args) {
        final SingletonTest test = new SingletonTest();
//        for (int i = 0; i < 10; i++) {
//            test.testSingleton1();
//        }

        System.out.println("=============");

        for (int i = 0; i < 10; i++) {
            new Thread(test::testSingleton1
            ).start();
        }
    }

    private void testSingleton1(){
        Singleton1 a1 = Singleton1.getInstance();
        System.out.println(a1);
    }
}
