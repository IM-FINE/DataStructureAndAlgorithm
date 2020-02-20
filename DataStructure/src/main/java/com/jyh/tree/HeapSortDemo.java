package com.jyh.tree;

/**
 * @Author: jyh
 * @Date: 2020/2/11
 * @Description: com.jyh.tree
 * @version: 1.0
 */

import java.util.Arrays;

/**
 * 堆排序(大顶堆) 完全二叉树
 * 1、从非叶子节点开始，以该节点为根节点进行排序，最后一个非叶子节点序号为(arr.length/2)-1
 * 原因：https://www.cnblogs.com/malw/p/10542557.html
 * 2、
 */
public class HeapSortDemo {
    public static void main(String[] args) {
//        int[] arr = {11, 3, 4, 45, 6, 3, 23, 34, 23, 12, 33};
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));

        int max = 8000000;
        int[] arr2 = new int[max];
        for (int i = 0; i < max; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }
        long startTime = System.currentTimeMillis();    //获取开始时间
        heapSort(arr2); //3
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) + "ms");
//        System.out.println(Arrays.toString(arr2));
    }

    public static void heapSort(int[] arr) {
        //1、将无序数组构建为大顶堆并将最大元素"下沉"
        int len = arr.length;
        //最后一个非叶子节点
        int noLeaf = (arr.length / 2) - 1;
        for (int i = noLeaf; i >= 0; i--) {
            partSort(arr, i, len);
        }
        //将根元素与最后一个元素交换
        int tmp = arr[0];
        arr[0] = arr[len - 1];
        arr[len - 1] = tmp;
        len--;

        //2、重新调整结构
        while (len > 1) {
            partSort(arr, 0, len);
            //将根元素与最后一个元素交换
            tmp = arr[0];
            arr[0] = arr[len - 1];
            arr[len - 1] = tmp;
            len--;
        }
    }

    /**
     * 使最大的元素到根节点
     *
     * @param arr    要排序的数组
     * @param i      以i为根节点
     * @param length 要比较的长度
     */
    public static void partSort(int[] arr, int i, int length) {
        //最后一个非叶子节点
        int noLeaf = (length / 2) - 1;
        //如果i不是非叶子节点，结束
        if (i > noLeaf) {
            return;
        }

        int left = 2 * i + 1;//左子节点位置
        int right = 2 * i + 2;//右子节点位置
        int tmp = left; //临时指针指向左子节点，指向子节点中最大的节点

        int val = arr[i];//将i位置的元素保存在临时变量里
        //如果右子节点存在并且左子节点小于右子节点，让指针tmp指向右子节点
        if (right < length && arr[left] < arr[right]) {
            tmp++;
        }
        //如果根节点小于最大子节点，交换
        if (val < arr[tmp]) {
            arr[i] = arr[tmp];
            arr[tmp] = val;
            //以交换后的节点为根节点递归
            partSort(arr, tmp, length);
        }
    }
}
