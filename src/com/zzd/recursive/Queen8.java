package com.zzd.recursive;

/**
 * @Author ZZD
 * @Date 2020/7/25 15:47
 * @Email 1396896729@qq.com
 */
public class Queen8 {
    private int max = 8;
    //存储最终的答案 类似04752613
    private int[] arr = new int[max];
/**
 * @params n 表示当前为第几个皇后
 * @return
 */
    public void check(int n) {
        //如果n == 数组的长度。表示已经摆放完8个棋子。得到一个答案，打印即可。
        if (n==max){
            print();
            return;
        }
        //有8行所以循环八次。
        for (int i = 0; i < max; i++) {
            //i表示皇后所在的列的位置，arr[n] = 表示第几个皇后
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    /**
     * @params
     * @return
     *
     * 判断第n个皇后所放的位置与前面是否有重复的
     */
    private boolean judge(int n) {
        //从第一行开始遍历。
        for (int i = 0; i < n; i++) {
            //如果再同一行表示重复。  根据两点的斜率来判断是否处在同一斜线上（y2-y1）==(x2-x2)相等表示斜率为1 处在同一个斜线上。所以该位置不能放在棋子，返回false
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
    //打印结果
    private void print(){
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
