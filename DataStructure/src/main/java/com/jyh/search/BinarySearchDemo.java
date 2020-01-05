package com.jyh.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jyh
 * @Date: 2020/1/5
 * @Description: com.jyh.search
 * @version: 1.0
 */
public class BinarySearchDemo {
    public static List<Integer> resList = new ArrayList<>();

    public static void main(String[] args) {
//        int[] arr = {1, 8, 9, 10, 23, 28, 35, 49, 60, 89};
        int[] arr = {8, 8, 9, 10, 23, 28, 35, 49, 60, 89, 89};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 89));

    }

    public static List<Integer> binarySearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[left] || findValue > arr[right]) {
            return resList;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > findValue) { //往左边找
            return binarySearch(arr, left, mid - 1, findValue);
        } else if (arr[mid] < findValue) { //往右边找
            return binarySearch(arr, mid + 1, right, findValue);
        } else { //找到了，继续查找两边
            resList.add(mid);
            int tmp = mid - 1;
            while (tmp >= 0 && arr[tmp] == findValue) { //往左边找
                resList.add(tmp);
                tmp--;
            }
            tmp = mid + 1;
            while (tmp <= arr.length - 1 && arr[tmp] == findValue) { //往左边找
                resList.add(tmp);
                tmp++;
            }
            return resList;
        }
    }
}
