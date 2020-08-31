package com.zzd.test;

import com.zzd.sort.BubbleSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZZD
 * @Date 2020/7/25 21:40
 * @Email 1396896729@qq.com
 */
public class BubbleSortTest {
    public static void main(String[] args) {
      /*  int[] arr = {9,81,7,33,123,22,3212,223,121};*/
       /* int[] arr = {21,3,4,5,6,7,8,9};*/
        int[] arr = new int[80000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2000000)*-1;
        }
        long begin = System.currentTimeMillis();
        int[] sort = new BubbleSort().sort(arr);

       long end = System.currentTimeMillis();

        System.out.println("共耗时"+(end-begin));
    }
}
