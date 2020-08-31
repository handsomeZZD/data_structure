package com.zzd.test;

import com.zzd.tree.binarytree.BinarySortTree;

/**
 * @Author ZZD
 * @Date 2020/8/26 15:55
 * @Email 1396896729@qq.com
 */
public class BinarySortTreeTest {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int[] arr = {7,3,10,12,5,1,0,13,14,15,16,17};


        for (int i : arr) {
            binarySortTree.add(i);
        }

        binarySortTree.infixOrder();

       /* binarySortTree.delete(0);
        binarySortTree.delete(1);
        binarySortTree.delete(3);
        binarySortTree.delete(5);*/

        System.out.println("---------------------------");

        binarySortTree.infixOrder();




    }
}
