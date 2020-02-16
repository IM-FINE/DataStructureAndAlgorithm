package com.jyh.tree;

/**
 * @Author: jyh
 * @Date: 2020/1/13
 * @Description: com.jyh.tree
 * @version: 1.0
 */
//二叉树
public class BinaryTree {
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
        } else {
            root.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
        } else {
            root.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
        } else {
            root.postOrder();
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int id) {
        if (root != null) {
            return root.preOrderSearch(id);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int id) {
        if (root != null) {
            return root.infixOrderSearch(id);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int id) {
        if (root != null) {
            return root.postOrderSearch(id);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }
}
