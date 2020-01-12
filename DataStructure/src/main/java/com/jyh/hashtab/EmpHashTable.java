package com.jyh.hashtab;

import java.util.Arrays;

/**
 * @Author: jyh
 * @Date: 2020/1/12
 * @Description: com.jyh.hashtab
 * @version: 1.0
 */
//管理链表
public class EmpHashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    int index;

    public EmpHashTable(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //!!!要初始化每一个链表，否则无法操作链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加
    public void add(Emp emp) {
        index = hashMethod(emp.getId());
        empLinkedListArray[index].add(emp);
    }

    //删除
    public void delById(int id) {
        index = hashMethod(id);
        empLinkedListArray[index].delById(id);
    }

    //查找
    public Emp getById(int id) {
        index = hashMethod(id);
        return empLinkedListArray[index].getById(id);
    }

    //散列，根据id决定放在哪一个数组
    public int hashMethod(int id) {
        return id % size;
    }

    //遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ":\t");
            empLinkedListArray[i].list();
        }
        System.out.println();
    }
}
