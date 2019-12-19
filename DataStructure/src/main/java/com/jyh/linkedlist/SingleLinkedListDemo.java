package com.jyh.linkedlist;

/**
 * @Author: jyh
 * @Date: 2019/12/18
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表
        SingleLinkedList s = new SingleLinkedList();
        //添加到最后
//        s.add(heroNode1);
//        s.add(heroNode2);
//        s.add(heroNode3);
//        s.add(heroNode4);
//        s.list();

        //有序添加
        s.addByorder(heroNode2);
        s.addByorder(heroNode1);
        s.addByorder(heroNode4);
        s.addByorder(heroNode3);
        s.addByorder(heroNode1);
        s.list();

        System.out.println();

        //修改信息
        HeroNode heroNode5 = new HeroNode(7, "xxx", "xxx");
        s.update(heroNode5);
        s.list();
    }
}
