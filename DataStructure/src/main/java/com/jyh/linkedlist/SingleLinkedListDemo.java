package com.jyh.linkedlist;

import java.awt.*;
import java.util.Stack;

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
        HeroNode heroNode5 = new HeroNode(5, "xxx", "xxx");
        //创建链表
//        SingleLinkedList s = new SingleLinkedList();
        //添加到最后
//        s.add(heroNode1);
//        s.add(heroNode3);
//        s.add(heroNode4);
//        s.add(heroNode2);
//        s.list();

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
//        System.out.println(gentLength(s.getHead()));

        //查找单链表中倒数第k个节点
//        System.out.println(findLastIndexNode(s.getHead(), 1));

        //单链表的反转
//        reverseList(s.getHead());
//        s.list();

        //从尾到头打印单链表
//        reversePrint(s.getHead());

        //合并有序链表
        //有序添加
        //创建链表1、2
        SingleLinkedList s1 = new SingleLinkedList();
        SingleLinkedList s2 = new SingleLinkedList();
        s1.addByorder(heroNode3);
        s1.addByorder(heroNode1);
        s2.addByorder(heroNode4);
        s2.addByorder(heroNode2);
        s2.addByorder(heroNode5);
        s1.list();
        s2.list();

        SingleLinkedList s = mergeOrderList(s1, s2);
        s.list();


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

    //2、查找单链表中倒数第k个节点(新浪)
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

    //3、单链表的反转（腾讯）
    public static void reverseList(HeroNode head) {
        //判断链表是否为空或只有一个节点
        if (head.next == null || head.next.next == null) {
            return;
        }
        //借助新的头节点及辅助变量（指针）
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode tmp = head.next;
        //还需借助一个辅助变量next
        HeroNode next = null;
        while (tmp != null) {
            next = tmp.next;//先保存当前节点的下一节点
            tmp.next = reverseHead.next;
            reverseHead.next = tmp;
            tmp = next;
        }
        head.next = reverseHead.next;
    }

    //4、从尾到头打印单链表（百度）
    public static void reversePrint(HeroNode head) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }
        //借助栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode tmp = head.next;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //5、合并两个有序单链表，合并后仍然有序
    public static SingleLinkedList mergeOrderList(SingleLinkedList s1, SingleLinkedList s2) {
        //创建一个新的链表
        SingleLinkedList s = new SingleLinkedList();
        HeroNode head1 = s1.getHead();
        HeroNode head2 = s2.getHead();
        //如果两个链表为空
        if (head1.next == null && head2.next == null) {
            s.setHead(head1);
            return s;
        }
        //如果链表1为空，2不为空，返回2，否则返回1
        if (head1.next == null) {
            s.setHead(head2);
            return s;
        }
        if (head2.next == null) {
            s.setHead(head1);
            return s;
        }
        //两个都不为空，将2合并到1中
        //借助临时变量
        HeroNode tmp1 = head1;
        HeroNode tmp2 = head2.next;
        HeroNode next;
        boolean flag = false;//标志找到
        while (tmp2 != null) {
            //找tmp2插入的位置
            while (true) {
                if (tmp1.next == null) {
                    //到了1链表最后
                    flag = true;
                    break;
                } else if (tmp2.no == tmp1.next.no) {
                    //编号相同，不能插入，跳过
                    break;
                } else if (tmp2.no < tmp1.next.no) {
                    //找到了
                    flag = true;
                    break;
                }
                tmp1 = tmp1.next;
            }
            if (flag) {
                //找到位置，插入节点
                next = tmp2.next;
                tmp2.next = tmp1.next;
                tmp1.next = tmp2;
                tmp2 = next;
            } else {
                tmp2 = tmp2.next;
            }
            flag = false;
        }
        s.setHead(head1);
        return s;
    }
}
