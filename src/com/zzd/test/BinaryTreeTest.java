package com.zzd.test;

import com.zzd.tree.BinaryTree;
import com.zzd.tree.Node;

/**
 * @Author ZZD
 * @Date 2020/8/8 13:06
 * @Email 1396896729@qq.com
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(new Node(10,"zzd"));
        binaryTree.addNode(new Node(6,"zzdd"));
        binaryTree.addNode(new Node(7,"zzddd"));
        binaryTree.addNode(new Node(5,"zzdddd"));
        binaryTree.addNode(new Node(11,"zzd"));
        binaryTree.addNode(new Node(14,"zzdd"));
        binaryTree.addNode(new Node(15,"zzddd"));
        binaryTree.addNode(new Node(18,"zzdddd"));
        binaryTree.addNode(new Node(20,"zzd"));
        binaryTree.preOrder();


    }
}
