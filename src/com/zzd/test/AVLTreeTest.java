package com.zzd.test;

import com.zzd.tree.avl.AVLTree;

/**
 * @Author ZZD
 * @Date 2020/8/27 13:27
 * @Email 1396896729@qq.com
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] arr = {1,2,3,4,5,6,6,7,8};


        for (int i : arr) {
            avlTree.add(i);
        }

        int height = avlTree.height();

        avlTree.infixOrder();


    }
}
