package com.zzd.sort;

import java.util.Arrays;

/**
 * @Author ZZD
 * @Date 2020/8/23 14:38
 * @Email 1396896729@qq.com
 */
public class HeapSort {
    public static void sort(int[] arr) {
        HeapSort heapSort = new HeapSort();

        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            heapSort.adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            //交换堆顶元素与末尾元素
            heapSort.swap(arr, 0, j);
            //调整大顶堆
            heapSort.adjustHeap(arr, 0, j);
        }

    }

    //调整大顶堆
    private void adjustHeap(int[] arr, int i, int length) {
        //取出当前元素
        int temp = arr[i];

        //判断当前元素的子元素大小
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {

            //如果右子元素大于左子元素。将k指向右子元素
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //判断当前元素是否比子元素大，不大则进行交换。
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }


        }
        arr[i] = temp;
    }

    //交换元素
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
