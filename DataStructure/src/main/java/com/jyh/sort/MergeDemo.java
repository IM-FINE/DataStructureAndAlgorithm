package com.jyh.sort;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2019/12/31
 * @Description: com.jyh.sort
 * @version: 1.0
 */
public class MergeDemo {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 5, 7, 9, 0, 2, 4, 6, 8};
//        int[] tmpArr = new int[arr.length];
//        divideMerge(arr, 0, arr.length - 1, tmpArr);
//        System.out.println(Arrays.toString(arr));

        int max = 80000;
        int[] tmpArr2 = new int[max];
        int[] arr2 = new int[max];
        for (int i = 0; i < max; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }
        long startTime = System.currentTimeMillis();    //获取开始时间
        divideMerge(arr2, 0, arr2.length - 1, tmpArr2); //12
//        shellMove(arr); //0.031
//        shellMove2(arr); //0.031
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) + "ms");
//        System.out.println(Arrays.toString(arr2));
    }

    //分解合并
    public static void divideMerge(int[] arr, int left, int right, int[] tmpArr) {
        if (left < right) {
            int mid = (left + right) / 2;
            divideMerge(arr, left, mid, tmpArr);//左分解
            divideMerge(arr, mid + 1, right, tmpArr);//右分解
            merge(arr, left, mid, right, tmpArr);//合并
        }
    }

    //合并,假设两边已排好序
    public static void merge(int[] arr, int left, int mid, int right, int[] tmpArr) {
        int tmp = left;//临时数组的指针
        int i = left;//左边数组的指针
        int j = mid + 1;//右边数组的指针
        while (i <= mid && j <= right) { //两边数组没遍历完时
            if (arr[i] <= arr[j]) { //左边数组当前(i)元素小于右边数组当前(j)元素
                tmpArr[tmp] = arr[i];
                i++;
                tmp++;
            } else {
                tmpArr[tmp] = arr[j];
                j++;
                tmp++;
            }
        }
        while (i <= mid) {//如果左边数组没有遍历完
            tmpArr[tmp] = arr[i];
            i++;
            tmp++;
        }
        while (j <= right) {//如果右边边数组没有遍历完
            tmpArr[tmp] = arr[j];
            j++;
            tmp++;
        }

        //拷贝tmpArr到arr中
        while (left <= right) {
            arr[left] = tmpArr[left];
            left++;
        }
    }
}
