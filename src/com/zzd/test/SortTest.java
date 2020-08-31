package com.zzd.test;

import com.zzd.sort.BubbleSort;
import com.zzd.sort.InsertionSort;
import com.zzd.sort.SelectionSort;
import com.zzd.sort.ShellSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZZD
 * @Date 2020/7/26 12:29
 * @Email 1396896729@qq.com
 */
public class SortTest {
    public static void main(String[] args) {
        //int[] arr = new int[80000];
        int[] arr = {9,81,7,33,123,22,3212,223,121};
        Random random = new Random();
       /* for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8000000);
        }
*/
        long begin = System.currentTimeMillis();
        /*int[] sort = new SelectionSort().sort(arr);

        int[] sort = new BubbleSort().sort(arr);*/
       /* int[] sort = new InsertionSort().sort(arr);*/
        int[] sort = new ShellSort().sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("共耗时"+(end-begin));



       /* int[] arr = {9,81,7,33,123,22,3212,223,121};
        int[] sort = new SelectionSort().sort(arr);

        System.out.println(Arrays.toString(sort));*/

        /*int[] arr = {9,81,7,33,123,22,3212,223,121};

        int[] sort = new InsertionSort().sort(arr);

        System.out.println(Arrays.toString(sort));*/
    }
}
