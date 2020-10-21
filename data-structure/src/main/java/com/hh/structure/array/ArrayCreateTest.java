package com.hh.structure.array;

/**
 * @Version: V1.0.0
 * @Description: 创建数组的几种方式
 * @Author: gorun
 * @date 2020/8/8
 */
public class ArrayCreateTest {

    public static void main(String[] args) {
        //创建数组的第一种方法
        int[] arr=new int[6];
        int intValue=arr[5];
        System.out.println(intValue);

        //创建数组的第二种方法
        int[] x={1,2,3,4};
        System.out.println(x[1]);

        //创建数组的第三种方法。
        int[] y= new int[]{1,2,3,4,5};
        int m=0;
        boolean length = isLength(m,y);
        if(length){
            System.out.println(y[m]);
        }else{
            System.err.println("数组标越界");
        }
    }

    //判断数组下标是否越界
    public static boolean isLength(int m,int arr[]){
        boolean flag=false;
        int length = arr.length;
        if(m<length)
            flag=true;
        return flag;
    }
}
