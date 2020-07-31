package com.zzd.sort;

/**
 * @Author ZZD
 * @Date 2020/7/27 20:19
 * @Email 1396896729@qq.com
 */
public class QuickSort {

    public int[] sort(int[] arr){
        this.quickSort(arr,0,arr.length-1);
        return arr;
    }



    private void quickSort(int[] arr, int left, int right) {
        //判断是继续分割数组
        if (right < left) {
            return;
        }

        int l = left;
        int r = right;
        int temp;
        //中位值为左边第一个值
        int middle = arr[left];
        while (r > l) {
            //从右边开始找，找到比中位值小的数
            while (middle <= arr[r] && r > l) {
                r--;
            }
            //从左边开始寻找，找到比中位值大的数
            while (middle >= arr[l] && l < r) {
                l++;
            }

            //交换两个数。继续查找
            if (r > l) {
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }


        }
        //交换中位值，使得左边的值都小于右边的值
        temp = arr[r];
        arr[r] = arr[left];
        arr[left] = temp;
        //继续递归查找
        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);

    }
}
