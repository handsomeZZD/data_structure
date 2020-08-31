package com.zzd.test;

import com.zzd.sort.HeapSort;
import com.zzd.sort.ShellSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZZD
 * @Date 2020/8/23 15:01
 * @Email 1396896729@qq.com
 */
public class HeapSortTest {
    public static void main(String[] args) {

        int[] arr = new int[8000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(80000000);
        }

        long begin = System.currentTimeMillis();
        /*int[] sort = new SelectionSort().sort(arr);

        int[] sort = new BubbleSort().sort(arr);*/
        /* int[] sort = new InsertionSort().sort(arr);*/
        HeapSort.sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("共耗时"+(end-begin));
    }
}
