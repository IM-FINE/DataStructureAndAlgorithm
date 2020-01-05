package com.jyh.search;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2020/1/5
 * @Description: com.jyh.search
 * @version: 1.0
 */
public class FibonacciSearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 10, 23, 28, 35, 49, 60, 89, 90};
        int[] fib = getFib(20);
        System.out.println(fibonacciSearch(arr, fib, 70));
    }

    //构造斐波那契数列
    public static int[] getFib(int length) {
        int[] fib = new int[length];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    //斐波那契查找
    public static int fibonacciSearch(int[] arr, int[] fib, int findValue) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0;//保存斐波那契数列的下标
        while (right + 1 > fib[k]) { //找到稍大于或等于arr长度的k
            k++;
            if (k > fib.length - 1) {
                System.out.println("请调整斐波那契数组的大小");
                return -1;
            }
        }
        int[] tmp = Arrays.copyOf(arr, fib[k]);
        //如果fib[k]大于数组长度，少的部分用数组最后的数填充
        for (int i = right + 1; i < tmp.length; i++) {
            tmp[i] = arr[right];
        }
        System.out.println(Arrays.toString(tmp));
        int mid = 0;//中值
        while (left <= right) {
            mid = left + fib[k - 1] - 1;
            if (tmp[mid] > findValue) { //往左边找
                right = mid - 1;
                // k如何变化？
                //前面f[k-1]个元素可继续拆分成f[k-2]+f[k-3]
                k--;
            } else if (tmp[mid] < findValue) {//往右边找
                left = mid + 1;
                //后面f[k-2]个元素可继续拆分成f[k-3]+f[k-4]
                k -= 2;
            } else { //找到了
                //判断超过最大长度下标没
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }
}
