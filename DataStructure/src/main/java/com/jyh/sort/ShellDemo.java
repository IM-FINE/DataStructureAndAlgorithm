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
        System.out.println(Arrays.toString(arr));
    }


    //交换法
    public static void shellExchange(int[] arr) {
        int tmp = 0;
        int step = arr.length / 2;
        for (int i = 0; i < arr.length-step; i++) {
            for (int j = i; j < arr.length - step; j += step) {
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
        for (int i = step; i < arr.length - step; i++) { //一共有step组
            for (int j = i; j < arr.length - step; j += step) {
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

    //移位法
    public static void shellMove(int[] arr) {
    }
}
