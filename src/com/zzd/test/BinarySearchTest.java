package com.zzd.test;

import com.zzd.search.BinarySearch;
import com.zzd.sort.QuickSort;

import java.util.Arrays;

/**
 * @Author ZZD
 * @Date 2020/7/31 20:57
 * @Email 1396896729@qq.com
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = {9, 81, 7, 33, 123, 22, 3212, 223, 121,2,4,55,44};
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        BinarySearch search = new BinarySearch();

        int value = search.search(arr, 33);

        System.out.println(value);
    }
}
