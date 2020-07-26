package com.zzd.sort;

/**
 * @Author ZZD
 * @Date 2020/7/26 12:15
 * @Email 1396896729@qq.com
 */
public class SelectionSort {

    //用于交换的零时变量
    private int temp;
    //用于保存最小值的下标位置
    private int index;

    public int[] sort(int[] arr) {
        //循环遍历长度-1遍
        for (int i = 0; i < arr.length - 1; i++) {
            //从当前位置开始选则
            index = i ;
            for (int j = index+1; j < arr.length; j++) {
                //如果找到比当前小的值，将较小的值的下标赋值给index
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            //如果下标不变说明没发生过交换意味着当前已经是最小值 直接进入下轮循环
            if (index==i){
                continue;
            }
            //把最小值换到当前的位置
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

        }
        return arr;
    }
}
