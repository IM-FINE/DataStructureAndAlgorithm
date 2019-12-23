package com.jyh.stack;

/**
 * @Author: jyh
 * @Date: 2019/12/23
 * @Description: com.jyh.stack
 * @version: 1.0
 */
public class ArrayStack {
    private int maxSize;//栈的大小
    private int top = -1;//栈顶指针，初始化为-1
    private int[] stack;//int数组，用来实现栈

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int val) {
        //如果栈满
        if (isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        top++;
        stack[top] = val;
    }

    //出栈
    public int pop() {
        //如果栈为空
        if (isEmpty()) {
            throw new RuntimeException("栈是空的");
        }
        int val = stack[top];
        top--;
        return val;
    }

    //返回栈顶元素
    public int peek() {
        //如果栈为空
        if (isEmpty()) {
            throw new RuntimeException("栈是空的");
        }
        return stack[top];
    }

    //遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈是空的");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("索引为%d的元素为%d\n", i, stack[i]);
        }
    }
}
