package com.gorun.design_pattern.singleton;

/**
 * @Version: V1.0.0
 * @Description: 懒汉式加载 加锁前后两次判断实例是否已经存在
 * 只有当instance为null即没有创建时，需要加锁操作，创建一次实例。当实例被创建，则无需试图加锁。
 * @Author: gorun
 * @date 2020/8/1
 */
public class Singleton3 {

    private static Singleton3 instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if(instance == null){
            synchronized (Singleton3.class){
                if (instance == null) {
                    instance = new Singleton3();
                }
            }

        }
        return instance;
    }
}
