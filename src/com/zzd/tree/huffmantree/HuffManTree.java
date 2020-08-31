package com.zzd.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ZZD
 * @Date 2020/8/23 22:17
 * @Email 1396896729@qq.com
 */
public class HuffManTree {


    public static void createHuffmanTree(int[] arr) {
        //方便排序先将数组转成ArrayList
        List<Node> nodes = new ArrayList<Node>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }

        /*
            循环将最小的两 个数组成新的二叉树
            然后将最小的数移除
            将新的二叉树放到数组中
            直达数组中只剩一个数为止

         */
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes, new NodeComparator());
            //取出最小的两位将其组合一个新的二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.getValue() + rightNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            //将其从数组中移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //把新的节点放入数组中。
            nodes.add(parent);
        }


    }

}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

}
//实现比较接口
class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.getValue() - o2.getValue();
    }
}
