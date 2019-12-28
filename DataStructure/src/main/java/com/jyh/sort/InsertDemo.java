package com.jyh.sort;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2019/12/28
 * @Description: com.jyh.sort
 * @version: 1.0
 */
public class InsertDemo {
    public static void main(String[] args) {
        int max = 80000;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
//        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();    //获取开始时间
        insert(arr);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) / 1000);
//        System.out.println(Arrays.toString(arr));
    }

    private static void insert(int[] arr) {
        int tmp;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) { //从第1个元素开始，因为第0个元素已经有序
            insertIndex = i - 1;//假设插入的位置是该元素前面一位
            tmp = arr[i];//先把该元素保存
            while (insertIndex >= 0 && tmp < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//向后面移动一位，腾出位置
                insertIndex--;
            }
            //循环结束，insertIndex+1即为插入的位置
            //优化：如果insertIndex+1就是该元素的位置i，就不需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = tmp;
            }
        }

    }
}
