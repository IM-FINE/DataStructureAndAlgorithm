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
        s.add(heroNode1);
        s.add(heroNode2);
        s.add(heroNode3);
        s.add(heroNode4);
        s.list();

        //有序添加
//        s.addByorder(heroNode2);
//        s.addByorder(heroNode1);
//        s.addByorder(heroNode4);
//        s.addByorder(heroNode3);
//        s.addByorder(heroNode1);
//        s.list();


        //修改信息
//        HeroNode heroNode5 = new HeroNode(7, "xxx", "xxx");
//        s.update(heroNode5);
//        s.list();

        //链表有效节点的个数
        System.out.println(gentLength(s.getHead()));

        //查找单链表中倒数第k个节点
        System.out.println(findLastIndexNode(s.getHead(), 1));


    }

    //面试题
    //1、获取单链表有效节点的个数，给定头节点
    public static int gentLength(HeroNode head) {
        int length = 0;
        HeroNode tmp = head.next;
        //节点不为空，计数+1
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    //2、查找单链表中倒数第k个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //如果链表为空
        if (head.next == null) {
            return null;
        }
        //得到链表的长度
        int length = gentLength(head);
        //先判断index的合法性
        if (index <= 0 || index > length) {
            System.out.println("index不合规范");
            return null;
        }
        HeroNode tmp = head.next;
        //length-index即为要找的节点位置，tmp从第一个节点向后移动length-index次
        for (int i = 0; i < length - index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
