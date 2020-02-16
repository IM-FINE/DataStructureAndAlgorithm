package com.jyh.tree;

/**
 * @Author: jyh
 * @Date: 2020/1/13
 * @Description: com.jyh.tree
 * @version: 1.0
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode a = new HeroNode(1, "A");
        HeroNode b = new HeroNode(2, "B");
        HeroNode c = new HeroNode(3, "C");
        HeroNode d = new HeroNode(4, "D");
        HeroNode e = new HeroNode(5, "E");
        HeroNode f = new HeroNode(6, "F");
        HeroNode g = new HeroNode(7, "G");
        g.setLeft(c);
        g.setRight(e);
        c.setLeft(a);
        c.setRight(b);
        e.setLeft(d);
        e.setRight(f);

        BinaryTree binaryTree = new BinaryTree(g);

//        binaryTree.preOrder();
//        binaryTree.infixOrder();
        System.out.println(binaryTree.infixOrderSearch(5));



    }
}
