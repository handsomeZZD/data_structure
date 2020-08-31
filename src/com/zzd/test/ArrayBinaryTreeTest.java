package com.zzd.test;

import com.zzd.tree.ArrayBinaryTree;

/**
 * @Author ZZD
 * @Date 2020/8/22 21:09
 * @Email 1396896729@qq.com
 */
public class ArrayBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);

        arrayBinaryTree.preOrder();
    }
}
