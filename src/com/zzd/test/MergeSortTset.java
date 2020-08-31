package com.zzd.test;

import com.zzd.sort.MergeSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZZD
 * @Date 2020/7/31 13:17
 * @Email 1396896729@qq.com
 */
public class MergeSortTset {
    public static void main(String[] args) {
        //int[] arr = {9, 81, 7, 33, 123, 22, 3212, 223, 121,2,4,55,44};


        //  System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000000];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8000000);
        }

        long begin = System.currentTimeMillis();
        new MergeSort().sort(arr, 0, arr.length - 1);


        long end = System.currentTimeMillis();

        System.out.println("共耗时" + (end - begin));

        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(arr));
    }
}

