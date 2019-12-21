package com.jyh.linkedlist;

/**
 * @Author: jyh
 * @Date: 2019/12/18
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */

//管理英雄的类
class SingleLinkedList {
    //初始化头节点，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加节点到链表，需借助辅助变量tmp
    public void add(HeroNode heroNode) {
        HeroNode tmp = head;
        while (true) {
            //判断是否到最后
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = heroNode;
    }

    //按照编号大小顺序添加
    public void addByorder(HeroNode heroNode) {
        //因为头节点不能动，所以需要借助辅助变量
        HeroNode tmp = head;
        boolean flag = false;//标识添加的编号是否存在，默认false
        while (true) {
            //是否到链表最后
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no > heroNode.no) {
                //找到了
                break;
            } else if (tmp.next.no == heroNode.no) {
                //编号存在
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) { //编号已经存在
            System.out.println("编号为" + heroNode.no + "的英雄已经存在");
        } else {  //插入到链表中
            //1、新节点的next指向tmp的next
            heroNode.next = tmp.next;
            //2、tmp的next指向新节点
            tmp.next = heroNode;
        }
    }

    //修改节点信息，不能修改编号(即根据编号来修改)
    public void update(HeroNode heroNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode tmp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (tmp == null) { //已遍历完链表
                break;
            }
            if (tmp.no == heroNode.no) { //找到了
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.name = heroNode.name;
            tmp.nickname = heroNode.nickname;
        } else {
            System.out.println("没有找到编号为" + heroNode.no + "的英雄");
        }
    }

    //遍历链表,需借助辅助变量tmp
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }
        HeroNode tmp = head.next;
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
