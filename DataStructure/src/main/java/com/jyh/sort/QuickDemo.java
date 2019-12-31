package com.jyh.sort;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2019/12/31
 * @Description: com.jyh.sort
 * @version: 1.0
 */
public class QuickDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 7, 8, 6, 1, 2, 6};
//        int[] arr = new int[]{0,1};
        System.out.println(Arrays.toString(arr));
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int max = 80000;
        int[] arr2 = new int[max];
        for (int i = 0; i < max; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }
        long startTime = System.currentTimeMillis();    //获取开始时间
        quick(arr2, 0, arr2.length - 1); //12
//        shellMove(arr); //0.031
//        shellMove2(arr); //0.031
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) + "ms");
    }

    public static void quick(int[] arr, int left, int right) {
        //如果不传int left, int right，则无法递归，只有切片再合并(复杂)
        int l = left; //左指针
        int r = right; //右指针
        int baseVal = arr[left]; //以最左边作为基准值，相当于在最左边留出一个坑，baseVal保存着最左边的值
        while (l < r) { //当左指针小于右指针就一直循环
            while (l < r && arr[r] >= baseVal) { //当右边大于等于基准值，左移
                r--;
            }
            //当右边找到小于基准值的元素，移到左边的坑中，在右边留下一个坑
            arr[l] = arr[r];
            while (l < r && arr[l] <= baseVal) { //当左边小于等于基准值，右移
                l++;
            }
            //当左边找到大于基准值的元素，移到右边的坑中，在左边留下一个坑
            arr[r] = arr[l];
        }
        //循环结束，基准值归位
        arr[l] = baseVal;
        r--;
        l++;
        if (left < r) {
            quick(arr, left, r); //左递归
        }
        if (l < right) {
            quick(arr, l, right);//右递归
        }
    }

//    public static void quick(int[] arr, int left, int right) {
//        //如果不传int left, int right，则无法递归，只有切片再合并(复杂)
//        int l = left; //左指针
//        int r = right; //右指针
//        int baseVal = arr[(r + l) / 2]; //基准值
//        int tmp = 0;
//
//        while (l < r) { //当左指针小于右指针就一直循环
//            if (arr[l] == arr[r]) { //如果有重复的元素
//                l++;
//            } else {
//                while (arr[l] < baseVal) { //当在左边小于基准值，右移
//                    l++;
//                }
//                while (arr[r] > baseVal) { //当在右边大于基准值，左移
//                    r--;
//                }
//                //当左边找到大于基准值的元素、右边找到小于基准值的元素，交换
//                tmp = arr[l];
//                arr[l] = arr[r];
//                arr[r] = tmp;
//            }
//        }
//        if (r > 1) {
//            r--;
//            quick(arr, left, r);
//        }
//        if (l < arr.length - 2) {
//            l++;
//            quick(arr, l, right);
//        }
//    }
}
