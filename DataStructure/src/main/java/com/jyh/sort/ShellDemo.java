package com.jyh.sort;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2019/12/30
 * @Description: com.jyh.sort
 * @version: 1.0
 */
public class ShellDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println(Arrays.toString(arr));
        shellExchange(arr);
//        shellMove(arr);
//        shellMove2(arr);
        System.out.println(Arrays.toString(arr));
        int max = 80000;
        int[] arr2 = new int[max];
        for (int i = 0; i < max; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }
        long startTime = System.currentTimeMillis();    //获取开始时间
        shellExchange(arr2); //12
//        shellMove(arr); //0.031
//        shellMove2(arr); //0.031
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) / 1000);
    }


    //交换法
    public static void shellExchange(int[] arr) {
        int tmp = 0;
        for (int step = arr.length / 2; step > 0; step /= 2)
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) { //假设j为要插入的位置，如果不是就交换
                    if (arr[j] > arr[j + step]) {
                        tmp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = tmp;
                    }else {
                        break;
                    }
                }
            }
        /*
        int step = arr.length / 2;
        for (int i = step; i < arr.length; i++) {
            for (int j = i - step; j >= 0; j -= step) {
                if (arr[j] > arr[j + step]) {
                    tmp = arr[j];
                    arr[j] = arr[j + step];
                    arr[j + step] = tmp;
                }
            }
        }
        //3516089472
        System.out.println("第一次交换：" + Arrays.toString(arr));
        //31097 56842
        //0214357698
        step = step / 2;
        for (int i = step; i < arr.length; i++) {
            for (int j = i - step; j >= 0; j -= step) {
                if (arr[j] > arr[j + step]) {
                    tmp = arr[j];
                    arr[j] = arr[j + step];
                    arr[j + step] = tmp;
                }
            }
        }
        System.out.println("第二次交换：" + Arrays.toString(arr));

        step = step / 2;

        System.out.println("第三次交换：" + Arrays.toString(arr));
        */
    }

    //移位法
    public static void shellMove(int[] arr) {
        int tmp = 0;
        for (int step = arr.length / 2; step > 0; step /= 2)
            for (int i = step; i < arr.length; i++) {
                int j = i - step;//假定j为要插入的位置
                tmp = arr[i];//先把该元素保存下来
                while (j >= 0 && tmp < arr[j]) {
                    arr[j + step] = arr[j];//j不是要插入的位置，向后面移动
                    j -= step;
                }
                if (j + step != i) {
                    arr[j + step] = tmp;
                }
            }
    }

    //移位法2
    public static void shellMove2(int[] arr) {
        int tmp = 0;
        for (int step = arr.length / 2; step > 0; step /= 2)
            for (int i = step; i < arr.length; i++) {
                tmp = arr[i];//先把该元素保存下来
                int j;
                for (j = i - step; j >= 0; j -= step) { //假定j为要插入的位置
                    if (tmp < arr[j]) {
                        arr[j + step] = arr[j];//j不是要插入的位置，向后面移动
                    } else {
                        break;
                    }
                }
                if (j + step != i) {
                    arr[j + step] = tmp;
                }
            }
    }
}

//交换法
//    public static void shellExchange(int[] arr) {
//        int tmp = 0;
//
//        for (int step = arr.length / 2; step > 0; step /= 2) {
//            for (int i = 0; i < step; i++) { //一共有step组
//                for (int j = 0; j < arr.length - step; j += step) { //每组一共比较多少趟
//                    for (int k = i; k < arr.length - step - j; k += step) { //每比较完一趟，比较的次数减1
//                        if (arr[k] > arr[k + step]) {
//                            tmp = arr[k];
//                            arr[k] = arr[k + step];
//                            arr[k + step] = tmp;
//                        }
//                    }
//                }
//
//            }
//        }
//
//
///*
//        for (int i = 0; i < step; i++) { //一共有step组
//            for (int j = 0; j < arr.length - step; j += step) { //每组一共比较多少趟
//                for (int k = i; k < arr.length - step - j; k += step) { //每比较完一趟，比较的次数减1
//                    if (arr[k] > arr[k + step]) {
//                        tmp = arr[k];
//                        arr[k] = arr[k + step];
//                        arr[k + step] = tmp;
//                    }
//                }
//            }
//
//        }
//        //3516089472
//        System.out.println("第一次交换：" + Arrays.toString(arr));
//        //31097 56842
//        //0214357698
//        step = step / 2;
//        for (int i = 0; i < step; i++) { //一共有step组
//            for (int j = 0; j < arr.length - step; j += step) { //每组一共比较多少趟
//                for (int k = i; k < arr.length - step - j; k += step) { //每比较完一趟，比较的次数减1
//                    if (arr[k] > arr[k + step]) {
//                        tmp = arr[k];
//                        arr[k] = arr[k + step];
//                        arr[k + step] = tmp;
//                    }
//                }
//            }
//
//        }
//        System.out.println("第二次交换：" + Arrays.toString(arr));
//
//        step = step / 2;
//        for (int i = 0; i < step; i++) { //一共有step组
//            for (int j = 0; j < arr.length - step; j += step) { //每组一共比较多少趟
//                for (int k = i; k < arr.length - step - j; k += step) { //每比较完一趟，比较的次数减1
//                    if (arr[k] > arr[k + step]) {
//                        tmp = arr[k];
//                        arr[k] = arr[k + step];
//                        arr[k + step] = tmp;
//                    }
//                }
//            }
//
//        }
//        System.out.println("第三次交换：" + Arrays.toString(arr));
// */
//    }
