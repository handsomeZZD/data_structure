package com.zzd.tree;

/**
 * @Author ZZD
 * @Date 2020/8/22 21:01
 * @Email 1396896729@qq.com
 */
public class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }

        System.out.println(arr[index]);

        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }

        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
}
