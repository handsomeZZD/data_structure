package com.zzd.test;

import com.zzd.sort.ShellSort;
import com.zzd.sort.ShellSort2;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZZD
 * @Date 2020/7/27 14:47
 * @Email 1396896729@qq.com
 */
public class ShellSortTset {

    public static void main(String[] args) {
        //int[] arr = {9,81,7,33,123,22,3212,223,121};
        //int[] sort = new ShellSort2().sort(arr);

      //  System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];

        Random random = new Random();
       for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8000000);
        }

        long begin = System.currentTimeMillis();
        /*int[] sort = new SelectionSort().sort(arr);

        int[] sort = new BubbleSort().sort(arr);*/
        /* int[] sort = new InsertionSort().sort(arr);*/
        int[] sort = new ShellSort2().sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("共耗时"+(end-begin));


    }

}
