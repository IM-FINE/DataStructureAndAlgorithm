package com.jyh.queue;

/**
 * @Author: jyh
 * @Date: 2019/12/15
 * @Description: com.jyh.queue
 * @version: 1.0
 */
class ArrayQueue {
    private int maxSize; //数组最大容量
    private int front; //队列头指针，指向头的前一个位置
    private int rear; //队列尾指针，指向队列尾部
    private int[] arr; //用来模拟队列的数组

    //用来创建队列的构造器
    public ArrayQueue(int arrMaxsize) {
        maxSize = arrMaxsize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列是空的！");
        }
        front++;
        return arr[front];
    }

    //显示队列头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的！");
        }
        return arr[front + 1];
    }
    //显示队列所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            throw new RuntimeException("队列是空的！");
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}
