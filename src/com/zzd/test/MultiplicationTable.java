package com.zzd.test;

/**
 * @Author ZZD
 * @Date 2020/7/24 17:01
 * @Email 1396896729@qq.com
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j<=i){
                    System.out.print(j+"*"+i+"="+j*i+"  ");
                }
            }
            System.out.println();
        }
    }
}
