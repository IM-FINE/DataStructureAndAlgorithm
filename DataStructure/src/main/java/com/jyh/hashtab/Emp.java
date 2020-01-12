package com.jyh.hashtab;

/**
 * @Author: jyh
 * @Date: 2020/1/12
 * @Description: com.jyh.hashtab
 * @version: 1.0
 */

//雇员节点
public class Emp {
    private int id;//编号
    private String name;//名字
    private Emp next;//指向下一节点

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[编号：" + id + "-名字：" + name + "]";
    }
}
