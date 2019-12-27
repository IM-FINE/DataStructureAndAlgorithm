package com.jyh.recursion;

/**
 * @Author: jyh
 * @Date: 2019/12/27
 * @Description: com.jyh.recursion
 * @version: 1.0
 */
public class Queen8Demo {
    private static int max = 8;
    private static int count = 0;//共有多少种解法
    private static int conflictCount = 0;//检查冲突次数

    public static void main(String[] args) {
        int[] arr = new int[max]; //用一维数组表示棋盘，下标表示行，值表示列
        play(arr, 0);
        System.out.println(count);
        System.out.println(conflictCount);
    }

    //显示棋盘
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    //当放置第n个皇后(即第n行皇后)时，检测与n行之前的行的冲突
    //如放置第1行皇后，检查与第0行皇后的冲突
    public static boolean conflict(int[] arr, int n) {
        conflictCount++;
        for (int i = 0; i < n; i++) {
            //array[i]==array[n] 判断是否时同一列
            //是否在一条斜线？n的纵坐标减去i的纵坐标的除以n的横坐标减去i的横坐标的绝对值是否等于1，不要用/除法
            //|(n-i)/(arr[n]-arr[i])|==1
            //因为n递增，无需判断行是否相等
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs((arr[n] - arr[i]))) {
                return true;
            }
        }
        return false;
    }

    //放置第n个(行)皇后，递归
    public static void play(int[] arr, int n) {
        //结束条件
        if (n == max) {
            count++;
            show(arr);
            return;
        }
        //依次放置皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //把第n行皇后放在第i列
            arr[n] = i;
            //判断是否与前面冲突
            if (!conflict(arr, n)) { //如果不冲突，接着放
                play(arr, n + 1);
            }
        }
    }
}
