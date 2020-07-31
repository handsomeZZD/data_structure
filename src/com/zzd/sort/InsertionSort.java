package com.zzd.sort;

/**
 * @Author ZZD
 * @Date 2020/7/26 13:46
 * @Email 1396896729@qq.com
 */
public class InsertionSort {
    //插入的位置的索引。
    private int insertIndex;
    //插入到值
    private int insertValue;

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //从第二的值开始比较
            insertValue = arr[i + 1];
            //插入的位置
            insertIndex = i;
            //对比大小,如果插入的值小于当前要插入的坐标的值。则将值全部往后移动一位。则坐标往左移动，继续寻找合适的位置。
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //将值插入到当前位置,
            arr[insertIndex+1] = insertValue;
        }
        return arr;
    }
}
