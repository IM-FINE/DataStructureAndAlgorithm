package com.jyh.tree;

/**
 * @Author: jyh
 * @Date: 2020/1/13
 * @Description: com.jyh.tree
 * @version: 1.0
 */
public class HeroNode {
    private int id;
    private String name;
    private HeroNode left;//左子节点
    private HeroNode right;//右子节点

    public HeroNode(int id, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "[id:" + id + "-name:" + name + "]";
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
    }

    //后序遍历
    public void postOrder() {
    }
}
