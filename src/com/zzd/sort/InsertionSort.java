package com.zzd.sort;

/**
 * @Author ZZD
 * @Date 2020/7/26 13:46
 * @Email 1396896729@qq.com
 */
public class InsertionSort {
    private int insertIndex;
    private int insertValue;

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            insertValue = arr[i + 1];
            insertIndex = i;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;
        }
        return arr;
    }
}
