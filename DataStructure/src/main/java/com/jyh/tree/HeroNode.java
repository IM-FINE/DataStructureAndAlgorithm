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

    //前序遍历，递归
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历，递归
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历，递归
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找,根据id
    public HeroNode preOrderSearch(int id) {
        if (this.getId() == id) {
            return this;
        }
        HeroNode resNode = null;//存放查找结果
        if (this.left != null) { //往左递归
            resNode = this.left.preOrderSearch(id);
        }
        if (resNode != null) { //在左边找到了
            return resNode;
        }
        if (this.right != null) { //往右递归
            resNode = this.right.preOrderSearch(id);
        }
        return resNode;
    }

    //中序遍历查找,根据id
    public HeroNode infixOrderSearch(int id) {
        HeroNode resNode = null;//存放查找结果
        if (this.left != null) { //往左递归
            resNode = this.left.infixOrderSearch(id);
        }
        if (resNode != null) { //在左边找到了
            return resNode;
        }

        if (this.getId() == id) {
            return this;
        }

        if (this.right != null) { //往右递归
            resNode = this.right.infixOrderSearch(id);
        }
        return resNode;
    }

    //后序遍历查找,根据id
    public HeroNode postOrderSearch(int id) {
        HeroNode resNode = null;//存放查找结果
        if (this.left != null) { //往左递归
            resNode = this.left.postOrderSearch(id);
        }
        if (resNode != null) { //在左边找到了
            return resNode;
        }

        if (this.right != null) { //往右递归
            resNode = this.right.postOrderSearch(id);
        }
        if (resNode != null) { //在右边找到了
            return resNode;
        }

        if (this.getId() == id) {
            resNode = this;
        }
        return resNode;
    }
}
