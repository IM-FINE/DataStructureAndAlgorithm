package com.jyh.queue;

/**
 * @Author: jyh
 * @Date: 2019/12/17
 * @Description: com.jyh.queue
 * @version: 1.0
 */
public class CircleArrayQueue {
    private int maxSize; //数组最大容量
    private int front; //队列头指针，指向第一个元素，初始值为0
    private int rear; //队列尾指针，指向最后一个元素的后一个位置，初始值为0
    private int[] arr; //用来模拟队列的数组

    //用来创建队列的构造器
    public CircleArrayQueue(int arrMaxsize) {
        maxSize = arrMaxsize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        arr[rear] = n;
        //考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列是空的！");
        }
        int tmp = arr[front];
        //考虑取模
        front = (front + 1) % maxSize;
        return tmp;
    }

    //显示队列头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的！");
        }
        return arr[front];
    }

    //队列中的有效元素个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            throw new RuntimeException("队列是空的！");
        }
        //从front开始遍历，遍历有效元素个数
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }
}
