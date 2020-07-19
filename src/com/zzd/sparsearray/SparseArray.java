package com.zzd.sparsearray;


import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws Exception {
        //初始化稀疏数组的行数
        int sum = 0;
        //创建10*10的二维数组
        int[][] chessArr = new int[10][10];
        chessArr[1][2] = 1;
        chessArr[3][4] = 2;
        chessArr[5][7] = 1;
        //遍历数组获取到sum的值
        System.out.println("以下是原始的数组:");
        for (int[] ints : chessArr) {
            for (int i : ints) {
                if (i!=0){
                    sum++;
                }
                System.out.printf(" %d ",i);
            }
            System.out.println("");

        }
        System.out.println("---------------------------------------------------------");
        //将二维数组转换成稀疏数组，并保存至文件夹中
        FileWriter fw = new FileWriter("file/data.txt");
        //创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //初始化计数器
        int n = 0;
        sparseArr[0][0]=chessArr.length;
        sparseArr[0][1]=chessArr[0].length;
        sparseArr[0][2]=sum;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j]!=0){
                    n++;
                    sparseArr[n][0] = i;
                    sparseArr[n][1] = j;
                    sparseArr[n][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("转换成稀疏数组:");
        for (int[] i : sparseArr) {
            for (int j : i) {
                System.out.printf("%-5d",j);
                fw.write(j);
            }
            System.out.println("");
        }
        fw.close();
        System.out.println("-----------------------------------------------------------");
        fw.close();

        FileReader fr = new FileReader("file/data.txt");

        //定义一个二维数组存放从文件中读取的数据
        int[][] chessArr2 = new int[fr.read()][fr.read()];

        int len = fr.read();

        for (int i = 0; i < len; i++) {
            chessArr2[fr.read()][fr.read()]=fr.read();
        }
        fr.close();
        for (int[] ints : chessArr2) {
            for (int i : ints) {
                System.out.printf(" %d ",i);
            }
            System.out.println("");

        }
    }
}
