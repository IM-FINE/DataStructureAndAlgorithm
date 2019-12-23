package com.jyh.stack;

/**
 * @Author: jyh
 * @Date: 2019/12/23
 * @Description: com.jyh.stack
 * @version: 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(11);
        arrayStack.push(12);
        arrayStack.push(13);
        arrayStack.push(14);
        arrayStack.push(15);
        arrayStack.list();
    }
}
