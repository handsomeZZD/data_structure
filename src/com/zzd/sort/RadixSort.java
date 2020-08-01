package com.zzd.sort;

/**
 * @Author ZZD
 * @Date 2020/7/31 18:38
 * @Email 1396896729@qq.com
 */
public class RadixSort {

    public void sort(int[] arr) {
        //创建一个二维的数组，表示桶。10个桶
        int[][] bucket = new int[10][arr.length];
        //存储，每个桶总共有多少个数
        int[] count = new int[10];
        int index = 0;
        int max = arr[0];
        int bit = 1;
        //获取最大的数的长度，
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        for (int m = 0; m < maxLength; m++) {
            for (int i = 0; i < arr.length; i++) {
                //获取，（个十百...）位的数每次加往左加一位
                int digit = (arr[i] / bit) % 10;

                //将获取的数，按照桶的下标放入
                bucket[digit][count[digit]] = arr[i];
                count[digit]++;
            }

            //将给桶里面的数，重新赋值给原数组。
            for (int j = 0; j < bucket.length; j++) {

                for (int k = 0; k < count[j]; k++) {
                    arr[index++] = bucket[j][k];

                }
                count[j] = 0;
            }
            index = 0;
            bit = bit*10;
        }


    }
}
