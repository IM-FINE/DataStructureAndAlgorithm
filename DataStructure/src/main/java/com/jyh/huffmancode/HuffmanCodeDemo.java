package com.jyh.huffmancode;

import java.util.*;

/**
 * @Author: jyh
 * @Date: 2020/2/13
 * @Description: com.jyh.huffmancode
 * @version: 1.0
 */
public class HuffmanCodeDemo {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        List<Node> nodeList = strToNodeList(content);
        Node root = createHuffmanTree(nodeList);

        System.out.println(getHuffmanCodes(root));
//        Node root = huffmanCode(content);
    }

    static StringBuilder stringBuilder = new StringBuilder();
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    private static Map<Byte, String> getHuffmanCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理root的左子树
        huffmanCode(root.left, "0", stringBuilder);
        //处理root的右子树
        huffmanCode(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * @param node
     * @param code          规定路径，左边0，右边1
     * @param stringBuilder
     */
    public static void huffmanCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder();
        sb.append(stringBuilder);
        sb.append(code);
        if (node != null) {
            //判断是否为叶子节点
            if (node.data == null) {
                //向左递归
                huffmanCode(node.left, "0", sb);
                //向右递归
                huffmanCode(node.right, "1", sb);
            } else { //是叶子节点
                huffmanCodes.put(node.data, sb.toString());
            }
        }
    }

    /**
     * 将字符串转换为节点列表
     *
     * @param str
     * @return
     */
    public static List<Node> strToNodeList(String str) {
        //统计字母数量并将其对应的byte作为key，数量作为value存入Map中
        byte[] bs = str.getBytes();
        Map<Byte, Integer> map = new HashMap();
        for (byte b : bs) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }
        //List，用来存储Node
        List<Node> nodeList = new ArrayList<>();
        //遍历Map，构建节点
        Set<Map.Entry<Byte, Integer>> entries = map.entrySet();
        for (Map.Entry<Byte, Integer> entry : entries) {
            Byte data = entry.getKey();
            int weight = entry.getValue();
            Node node = new Node(data, weight);
            nodeList.add(node);
        }
        //为nodeList排序
        Collections.sort(nodeList);
        return nodeList;
    }

    /**
     * 根据节点列表构建Huffman树
     *
     * @param nodeList
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodeList) {

        Node minNode;
        Node sMinNode;
        Node newNode;

        //如果集合元素数量大于1，取出前两个
        while (nodeList.size() > 1) {
            minNode = nodeList.get(0);
            sMinNode = nodeList.get(1);
            //构建新的节点
            newNode = new Node(null, minNode.weight + sMinNode.weight);
            //将左右指针指向之前两个节点
            newNode.left = minNode;
            newNode.right = sMinNode;
            //移除前两个节点
            //nodeList.remove(minNode);
            //nodeList.remove(sMinNode);
            nodeList.remove(0);
            nodeList.remove(0);
            //将新节点加入到集合
            nodeList.add(newNode);
            //重新排序
            Collections.sort(nodeList);
        }

        return nodeList.get(0);
    }
}
