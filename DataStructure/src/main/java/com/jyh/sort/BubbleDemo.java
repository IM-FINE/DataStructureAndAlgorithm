package com.jyh.sort;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2019/12/28
 * @Description: com.jyh.sort
 * @version: 1.0
 */
public class BubbleDemo {
    public static void main(String[] args) {
        //随机生成80000个数字的数组
        int max = 80000;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
//        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();    //获取开始时间
        optBubble(arr);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) / 1000);
//        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) { //一共比较n-1趟
            for (int j = 0; j < arr.length - 1 - i; j++) { //每比较完一趟，比较的次数减1
                if (arr[j] > arr[j + 1]) { //前一个元素比后一个元素大就发生交换
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //优化
    public static void optBubble(int[] arr) {
        boolean flag = false;//标识发生过交换没有
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) { //一共比较n-1趟
            for (int j = 0; j < arr.length - 1 - i; j++) { //每比较完一趟，比较的次数减1
                if (arr[j] > arr[j + 1]) { //前一个元素比后一个元素大就发生交换
                    flag = true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!flag) { //如果在一趟中没有发生过交换，则已经排好序了，跳出循环
                break;
            } else { //否则继续，并将flag重置
                flag = false;
            }
        }
    }
}
