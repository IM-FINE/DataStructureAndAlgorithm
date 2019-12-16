package com.jyh.sparsearray;

/**
 * @Author: jyh
 * @Date: 2019/12/12
 * @Description: com.jyh.sparsearray
 * @version: 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建原始二维数组 0表示无棋子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        //赋值
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        chessArr1[6][7] = 1;
        //遍历打印数组
        System.out.println("原始二维数组：");
        for (int[] i : chessArr1) {
            for (int j : i) {
                System.out.printf("%d\t", j);
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //遍历原始二维数组，得到非0元素的个数sum
        int sum = 0;
        for (int[] i : chessArr1) {
            for (int j : i) {
                if (j != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历原始二维数组，非0元素存放稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //遍历打印稀疏数组
        System.out.println("稀疏数组：");
        for (int[] i : sparseArr) {
            for (int j : i) {
                System.out.printf("%d\t", j);
            }
            System.out.println();
        }

        //恢复
        //先读取第一行sum，创建二维数组
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int total_row = sparseArr[0][2];
        int chessArr2[][] = new int[row][col];
        //读取后几行（从第二行开始）数据，赋值给二维数组
        for (int i = 1; i < total_row; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //遍历打印数组
        System.out.println("原始二维数组：");
        for (int[] i : chessArr1) {
            for (int j : i) {
                System.out.printf("%d\t", j);
            }
            System.out.println();
        }
    }
}
