package com.jyh.linkedlist;

/**
 * @Author: jyh
 * @Date: 2019/12/18
 * @Description: com.jyh.linkedlist
 * @version: 1.0
 */
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "[no:" + no + "\t" + "name:" + name + "\t" + "nickname:" + nickname+"]";
    }
}
