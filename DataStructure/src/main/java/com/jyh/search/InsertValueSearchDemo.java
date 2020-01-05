package com.jyh.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jyh
 * @Date: 2020/1/5
 * @Description: com.jyh.search
 * @version: 1.0
 */
public class InsertValueSearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 10, 23, 28, 35, 49, 60, 89, 90};
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 1));
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[left] || findValue > arr[right]) {
            return -1;
        }
        int mid = left + (right - left) * ((findValue - arr[left]) / (arr[right] - arr[left]));
        if (arr[mid] > findValue) { //往左边找
            return insertValueSearch(arr, left, mid - 1, findValue);
        } else if (arr[mid] < findValue) { //往右边找
            return insertValueSearch(arr, mid + 1, right, findValue);
        } else { //找到了
            return mid;
        }
    }
}
