package com.jyh.linkedlist;

/**
 * @Author: jyh
 * @Date: 2019/12/23
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */
public class Boy {
    private int no;//编号
    private Boy next;//下一节点

    //构造器
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
