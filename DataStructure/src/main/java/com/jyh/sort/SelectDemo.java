package com.jyh.sort;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2019/12/28
 * @Description: com.jyh.sort
 * @version: 1.0
 */
public class SelectDemo {
    public static void main(String[] args) {
        int max = 80000;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
//        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();    //获取开始时间
        select(arr);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) / 1000);
//        System.out.println(Arrays.toString(arr));
    }

    private static void select(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; //假定0为最小值的下标
            //从后面第一个开始比较，如果大于后面的数就改变最小下标和最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { //优化：如果最小值的下标该变，则交换
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
