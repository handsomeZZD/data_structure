package com.zzd.test;

import com.zzd.sort.MergeSort;
import com.zzd.sort.RadixSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZZD
 * @Date 2020/7/31 19:04
 * @Email 1396896729@qq.com
 */
public class RadixSortTest {
    public static void main(String[] args) {
        //int[] arr = {9, 81, 7, 33, 123, 22, 3212, 223, 121,2,4,55,44};




        int[] arr = new int[80000000];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8000000);
        }

        long begin = System.currentTimeMillis();
        new RadixSort().sort(arr);


        long end = System.currentTimeMillis();

        System.out.println("共耗时" + (end - begin));

        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(arr));
    }
}
