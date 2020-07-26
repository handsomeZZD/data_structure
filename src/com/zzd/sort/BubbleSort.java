package com.zzd.sort;

import java.util.Arrays;

/**
 * @Author ZZD
 * @Date 2020/7/25 21:34
 * @Email 1396896729@qq.com
 */
public class BubbleSort {
    //存储交换的零时变量
    private int temp;
    //判断是否发生过交换
    private boolean flag= false;

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                //比较大小，交换数值
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //发生过交换就将flag置为true
                    flag = true;

                }
            }
            //没交换直接return
            if (!flag) {
                return arr;
            }
        }
        return arr;
    }

}
