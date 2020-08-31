package com.zzd.test;

import com.zzd.search.BinarySearch;
import com.zzd.sort.QuickSort;
import com.zzd.sort.ShellSort2;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZZD
 * @Date 2020/7/27 21:48
 * @Email 1396896729@qq.com
 */
public class QuickSortTest {
    public static void main(String[] args) {
        //int[] arr = {9,81,7,33,123,22,3212,223,121};
        //int[] sort = new ShellSort2().sort(arr);

        //  System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8000009);
        }

        long begin = System.currentTimeMillis();
        int[] sort = new QuickSort().sort(arr);

        BinarySearch search = new BinarySearch();
        int x = search.search(arr, 7398696);
        System.out.println(x);

        if (x!=-1){
            System.out.println(arr[x]);
        }

        //System.out.println(Arrays.toString(arr));

        long end = System.currentTimeMillis();

        System.out.println("共耗时"+(end-begin));
        //System.out.println(Arrays.toString(arr));


    }
}
