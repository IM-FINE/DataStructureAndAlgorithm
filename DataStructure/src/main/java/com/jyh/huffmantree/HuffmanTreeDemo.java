package com.jyh.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: jyh
 * @Date: 2020/2/12
 * @Description: com.jyh.huffman
 * @version: 1.0
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = huffmanTree(arr);
        root.preOrder();
    }

    public static Node huffmanTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        //构造节点
        for (int value : arr) {
            Node node = new Node(value);
            list.add(node);
        }
        //排序
        Collections.sort(list);

        Node minNode;
        Node sMinNode;
        Node newNode;

        //如果集合元素数量大于1，取出前两个
        while (list.size() > 1) {
            minNode = list.get(0);
            sMinNode = list.get(1);
            //构建新的节点
            newNode = new Node(minNode.value + sMinNode.value);
            //将左右指针指向之前两个节点
            newNode.left = minNode;
            newNode.right = sMinNode;
            //移除前两个节点
            //list.remove(minNode);
            //list.remove(sMinNode);
            list.remove(0);
            list.remove(0);
            //将新节点加入到集合
            list.add(newNode);
            //重新排序
            Collections.sort(list);
        }

        return list.get(0);
    }

}
