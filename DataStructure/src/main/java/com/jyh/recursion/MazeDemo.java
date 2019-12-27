package com.jyh.recursion;

/**
 * @Author: jyh
 * @Date: 2019/12/27
 * @Description: com.jyh.recursion
 * @version: 1.0
 */
public class MazeDemo {
    public static void main(String[] args) {
        //二维数组模拟迷宫
        int[][] maze = new int[8][7];
        //设置墙(用1代表)
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        maze[2][1] = 1;
        maze[2][2] = 1;
        maze[2][4] = 1;
        maze[3][4] = 1;
        maze[4][4] = 1;
        maze[5][4] = 1;
        maze[6][4] = 1;
        //显示迷宫
        showMaze(maze);

        //给定起始位置，寻找出口
        setWay(maze, 1, 1);

        System.out.println("寻找出口...");

        //显示迷宫
        showMaze(maze);
    }

    //显示迷宫
    public static void showMaze(int[][] maze) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();

        }
    }

    //寻找出口并记录路线，找到返回true，没找到返回false
    public static boolean setWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            if (maze[i][j] == 0) {  //0代表没有走过
                maze[i][j] = 2; //假定能走通
                if (setWay(maze, i + 1, j)) { //向下走
                    return true;
                } else if (setWay(maze, i, j - 1)) { //向左走
                    return true;
                } else if (setWay(maze, i - 1, j)) { //向上走
                    return true;
                } else if (setWay(maze, i, j + 1)) { //向右走
                    return true;
                } else { //走不通
                    maze[i][j] = 3;
                    return false;
                }
            } else {  //该点不等于0，说明走过2或者走不通3或者是墙1
                return false;
            }
        }
    }
}
