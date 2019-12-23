package com.jyh.linkedlist;

/**
 * @Author: jyh
 * @Date: 2019/12/23
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */
public class CircleSingleLinkedList {
    //创建一个first，不能动，相当于头指针
    private Boy first = null;

    //添加
    public void addBoy(int nums) {
        //校验nums
        if (nums < 1) {
            System.out.println("nums不能小于1");
            return;
        }
        Boy curboy = null;//辅助变量，指向最后一个节点
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个节点,让first指向它,辅助指针也指向它
            if (i == 1) {
                first = boy;
                curboy = boy;
                curboy.setNext(first);
            } else {
                curboy.setNext(boy);//当前节点指向新节点
                boy.setNext(first);//新节点指向first
                curboy = boy;//辅助指针指向新节点
            }
        }
    }

    //遍历
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("环形链表是空的");
            return;
        }
        Boy curBoy = first;//辅助变量
        while (true) {
            System.out.printf("Boy:%d ->", curBoy.getNo());
            //如果到了最后一个
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //出圈

    /**
     * @param startNo  从第几个小孩开始数
     * @param countNum 数多少个数
     * @param nums     一共有几个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先校验参数
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("链表为空或参数有误");
            return;
        }
        //报数前，first移动startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
        }
        //辅助指针,先指向第一个节点
        Boy helper = first;
        //让辅助指针指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //报数时,first、helper移动countNum-1次，然后出圈
        while (true) {
            //圈中只剩一个节点
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("Boy:%d出圈\n", first.getNo());
            //出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("Boy:%d留在圈中", first.getNo());

    }
}
