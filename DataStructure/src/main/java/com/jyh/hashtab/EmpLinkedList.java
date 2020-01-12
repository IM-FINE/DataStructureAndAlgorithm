package com.jyh.hashtab;

/**
 * @Author: jyh
 * @Date: 2020/1/12
 * @Description: com.jyh.hashtab
 * @version: 1.0
 */

//管理雇员节点
public class EmpLinkedList {
    private Emp head;//头指针

    //添加雇员
    public void add(Emp emp) {
        //判断链表是否为空
        if (head == null) { //如果是
            head = emp;
            return;
        }
        //如果链表不为空，借助辅助指针
        Emp tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();//后移
        }
        tmp.setNext(emp);
    }

    //删除雇员
    public void delById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表是空的");
            return;
        }
        //不为空
        //找到待删除节点的前一个节点
        //如果待删除节点是第一个节点
        if (head.getId() == id) {
            head = head.getNext();
            return;
        }
        //如果待删除节点不是第一个节点
        Emp tmp = head;
        while (tmp.getNext().getId() != id) {
            if (tmp.getNext().getNext() == null) { //如果到最后了
                System.out.println("没找到编号为" + id + "的雇员");
                return;
            }
            tmp = tmp.getNext();//后移
        }
        //找到了
        tmp.setNext(tmp.getNext().getNext());
    }

    //根据id查找雇员
    public Emp getById(int id) {
        //判断链表是否为空
        //为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //链表不为空，借助辅助指针
        Emp tmp = head;
        while (tmp.getId() != id) {
            if (tmp.getNext() == null) { //如果到最后了
                System.out.println("没找到编号为" + id + "的雇员");
                return null;
            }
            tmp = tmp.getNext();//后移
        }
        return tmp;//找到了
    }

    //遍历链表
    public void list() {
        //如果链表为空
        if (head == null) {
            System.out.println("链表是空的");
            return;
        }
        //不为空
        Emp tmp = head;
        while (true) {
            if (tmp.getNext() != null) {
                System.out.print(tmp + "\t===>\t");
                tmp = tmp.getNext();//后移
            } else { //到最后了
                System.out.println(tmp);
                return;
            }
        }
    }
}
