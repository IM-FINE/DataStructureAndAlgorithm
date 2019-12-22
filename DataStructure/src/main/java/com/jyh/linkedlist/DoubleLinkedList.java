package com.jyh.linkedlist;

/**
 * @Author: jyh
 * @Date: 2019/12/18
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */

//管理英雄的类
class DoubleLinkedList {
    //初始化头节点，不存放具体的数据
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHead() {
        return head;
    }

    public void setHead(DoubleHeroNode head) {
        this.head = head;
    }

    //添加节点到链表，需借助辅助变量tmp
    public void add(DoubleHeroNode doubleHeroNode) {
        DoubleHeroNode tmp = head;
        while (true) {
            //判断是否到最后
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = doubleHeroNode;
        //新节点还得指向tmp
        doubleHeroNode.pre = tmp;
    }

    //按照编号大小顺序添加
    public void addByorder(DoubleHeroNode doubleHeroNode) {
        //因为头节点不能动，所以需要借助辅助变量
        DoubleHeroNode tmp = head;
        boolean flag = false;//标识添加的编号是否存在，默认false
        while (true) {
            //是否到链表最后
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no > doubleHeroNode.no) {
                //找到了
                break;
            } else if (tmp.next.no == doubleHeroNode.no) {
                //编号存在
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) { //编号已经存在
            System.out.println("编号为" + doubleHeroNode.no + "的英雄已经存在");
        } else {  //插入到链表中
            //1、新节点的next指向tmp的next
            doubleHeroNode.next = tmp.next;
            //2、tmp的next指向新节点
            tmp.next = doubleHeroNode;
        }
    }

    //删除节点
    public void del(DoubleHeroNode doubleHeroNode) {
        //如果链表为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        DoubleHeroNode tmp = head.next;
        boolean flag = false;//标志找到待删除的节点
        while (true) {
            if (tmp == null) {
                //到最后了，没找到
                break;
            }
            if (tmp.no == doubleHeroNode.no) {
                //找到了
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.pre.next = tmp.next;
            //注意，如果待删除的节点为最后一个不需要将下一节点指向前一节点，否则会报空指针异常
            if (tmp.next != null) {
                tmp.next.pre = tmp.pre;
            }
        } else {
            System.out.println("没有找到要删除的节点");
        }
    }

    //修改节点信息，不能修改编号(即根据编号来修改)
    public void update(DoubleHeroNode doubleHeroNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode tmp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (tmp == null) { //已遍历完链表
                break;
            }
            if (tmp.no == doubleHeroNode.no) { //找到了
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.name = doubleHeroNode.name;
            tmp.nickname = doubleHeroNode.nickname;
        } else {
            System.out.println("没有找到编号为" + doubleHeroNode.no + "的英雄");
        }
    }

    //遍历链表,需借助辅助变量tmp
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }
        DoubleHeroNode tmp = head.next;
        while (true) {
            //判断是否到最后
            if (tmp.next == null) {
                System.out.println(tmp);
                break;
            }
            System.out.print(tmp + "\t→\t");
            tmp = tmp.next;


        }
    }
}
