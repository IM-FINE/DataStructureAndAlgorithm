package com.jyh.sort;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2020/1/4
 * @Description: com.jyh.sort
 * @version: 1.0
 */
public class RadixDemo {
    public static void main(String[] args) {
//        int[] arr = new int[]{735, 23, 16, 2, 7, 235};
//        System.out.println(Arrays.toString(arr));
//        radix(arr);
//        System.out.println(Arrays.toString(arr));

        int max = 8000000;
        int[] tmpArr2 = new int[max];
        int[] arr2 = new int[max];
        for (int i = 0; i < max; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }
        long startTime = System.currentTimeMillis();    //获取开始时间
        radix(arr2);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (float) (endTime - startTime) + "ms");
//        System.out.println(Arrays.toString(arr2));

    }

    public static void radix(int[] arr) {
        int bucketNums = 10; //桶的数量
        int[][] bucket = new int[bucketNums][arr.length];//如果某一位所有数都相等，所以需要arr.length
        int[] bucketCount = new int[bucketNums]; //存放对应桶内元素的数量
        int index = 0;//用来计数从桶里取元素的数量
        int digit = 0;//用来存放个位数、十位数、百位数...

        //找到最大位数
        int maxIndex = 0;//最大数的索引
        for (int h = 1; h < arr.length; h++) {
            if (arr[h] > arr[maxIndex]) {
                maxIndex = h;
            }
        }

        int maxDigit = String.valueOf(arr[maxIndex]).length();

        for (int i = 0; i < maxDigit; i++) {
            //遍历元素，将个位数、百位数...放在对应的桶内
            for (int j = 0; j < arr.length; j++) {
                digit = (arr[j] / (int) Math.pow(10, i)) % 10;//百位数,代表放在第几个桶
                bucket[digit][bucketCount[digit]] = arr[j];
                bucketCount[digit]++;
            }

            //遍历桶，依次取出桶内的元素，放入原来的数组
            for (int k = 0; k < bucketNums; k++) {
                if (bucketCount[k] != 0) { //如果对应桶内元素数量不为0
                    for (int l = 0; l < bucketCount[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //将计数的桶置为0
                bucketCount[k] = 0;
            }
            //将index置为0
            index = 0;
//            System.out.println("第" + (i + 1) + "轮排序后的数组：" + Arrays.toString(arr));
        }

/*
        //遍历元素，将个位数、百位数...放在对应的桶内
        for (int j = 0; j < arr.length; j++) {
            digit = arr[j] % 10;//个位数,代表放在第几个桶
            bucket[digit][bucketCount[digit]] = arr[j];
            bucketCount[digit]++;
        }

        //遍历桶，依次取出桶内的元素，放入原来的数组
        for (int k = 0; k < bucketNums; k++) {
            if (bucketCount[k] != 0) { //如果对应桶内元素数量不为0
                for (int l = 0; l < bucketCount[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //将计数的桶置为0
            bucketCount[k] = 0;
        }
        //将index置为0
        index = 0;
        System.out.println("第一轮排序后的数组：" + Arrays.toString(arr));

        //遍历元素，将个位数、百位数...放在对应的桶内
        for (int j = 0; j < arr.length; j++) {
            digit = (arr[j] / 10) % 10;//十位数,代表放在第几个桶
            bucket[digit][bucketCount[digit]] = arr[j];
            bucketCount[digit]++;
        }

        //遍历桶，依次取出桶内的元素，放入原来的数组
        for (int k = 0; k < bucketNums; k++) {
            if (bucketCount[k] != 0) { //如果对应桶内元素数量不为0
                for (int l = 0; l < bucketCount[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //将计数的桶置为0
            bucketCount[k] = 0;
        }
        //将index置为0
        index = 0;
        System.out.println("第二轮排序后的数组：" + Arrays.toString(arr));

        //遍历元素，将个位数、百位数...放在对应的桶内
        for (int j = 0; j < arr.length; j++) {
            digit = (arr[j] / 100) % 10;//百位数,代表放在第几个桶
            bucket[digit][bucketCount[digit]] = arr[j];
            bucketCount[digit]++;
        }

        //遍历桶，依次取出桶内的元素，放入原来的数组
        for (int k = 0; k < bucketNums; k++) {
            if (bucketCount[k] != 0) { //如果对应桶内元素数量不为0
                for (int l = 0; l < bucketCount[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //将计数的桶置为0
            bucketCount[k] = 0;
        }
        //将index置为0
        index = 0;
        System.out.println("第三轮排序后的数组：" + Arrays.toString(arr));
 */
    }
}
