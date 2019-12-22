package com.jyh.linkedlist;

import java.util.Stack;

/**
 * @Author: jyh
 * @Date: 2019/12/18
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        DoubleHeroNode doubleHeroNode1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode doubleHeroNode2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode doubleHeroNode3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode doubleHeroNode4 = new DoubleHeroNode(4, "林冲", "豹子头");
        DoubleHeroNode doubleHeroNode5 = new DoubleHeroNode(5, "xxx", "xxx");
        //创建链表
        DoubleLinkedList d = new DoubleLinkedList();
        //添加到最后
        d.add(doubleHeroNode1);
        d.add(doubleHeroNode3);
        d.add(doubleHeroNode4);
        d.add(doubleHeroNode2);
        d.list();

        //删除
        d.del(doubleHeroNode5);
        d.list();


    }
}
