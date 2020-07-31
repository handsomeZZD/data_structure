package com.zzd.sort;

/**
 * @Author ZZD
 * @Date 2020/7/27 14:09
 * @Email 1396896729@qq.com
 * 希尔排序
 */
public class ShellSort2 {

    private int temp;
    private int index;

    public int[] sort(int[] arr) {

        //设置步长，循环一轮，步长减半。
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //分完组后遍历
            for (int i = step; i < arr.length; i++) {
                index = i;
                temp = arr[i];
                //使用插入排序，进行排序
                while (index-step >= 0 && temp < arr[index - step]) {
                    arr[index] = arr[index-step];
                    index -= step;

                }
                arr[index] = temp;
            }

        }
        return arr;
    }
}
