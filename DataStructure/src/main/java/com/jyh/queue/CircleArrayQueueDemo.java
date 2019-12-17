package com.jyh.queue;

import java.util.Scanner;

/**
 * @Author: jyh
 * @Date: 2019/12/15
 * @Description: com.jyh.queue
 * @version: 1.0
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):显示头部数据");
            key = scanner.next().charAt(0);//接收第一个字符
            switch (key) {
                case 's':
                    try {
                        circleArrayQueue.showQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.print("请输入要添加的数据：");
                    int n = scanner.nextInt();
                    try {
                        circleArrayQueue.addQueue(n);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'g':
                    try {
                        int get = circleArrayQueue.getQueue();
                        System.out.println(get);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int head = circleArrayQueue.headQueue();
                        System.out.println(head);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }


    }
}
