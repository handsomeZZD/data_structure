package com.zzd.sort;

/**
 * @Author ZZD
 * @Date 2020/7/31 12:56
 * @Email 1396896729@qq.com
 */
public class MergeSort {
    //递归的分割数组。并进行排序
    public void sort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }

    }

    private void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int l = start;
        int r = middle + 1;
        int t = 0;

        //按照大小将数放到一个零时的数组中
        while (l <= middle && r <= end) {

            if (arr[l] <= arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }


        }
        //将左边或者右两未放完的数依次放入零时数组。
        while (l <= middle) {
            temp[t++] = arr[l++];
        }
        while (r <= end) {
            temp[t++] = arr[r++];
        }
        t = 0;
        //将零时数组从新放到原始数组中。
        while (start <= end) {
            arr[start++] = temp[t++];
        }

    }
}
