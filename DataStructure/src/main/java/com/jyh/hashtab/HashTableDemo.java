package com.jyh.hashtab;

/**
 * @Author: jyh
 * @Date: 2020/1/12
 * @Description: com.jyh.hashtab
 * @version: 1.0
 */
public class HashTableDemo {
    public static void main(String[] args) {
        EmpHashTable empHashTable = new EmpHashTable(16);
        Emp emp1;
        Emp emp2;
        for (int i = 1; i < 27; i++) {
            emp1 = new Emp(i, (char) (i + 96) + "");
            emp2 = new Emp(i + 26, (char) (i + 64) + "");
            empHashTable.add(emp1);
            empHashTable.add(emp2);
        }
        empHashTable.list();
        empHashTable.delById(1);
        empHashTable.list();
        System.out.println(empHashTable.getById(2));
    }
}
