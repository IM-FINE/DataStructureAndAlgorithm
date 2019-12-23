package com.jyh.linkedlist;

/**
 * @Author: jyh
 * @Date: 2019/12/23
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */
public class JosephusDemo {
    public static void main(String[] args) {
        //创建环形链表
        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addBoy(100);
        c.showBoy();
        System.out.println();
        c.countBoy(8, 10, 100);

    }
}
