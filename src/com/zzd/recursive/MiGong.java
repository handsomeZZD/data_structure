package com.zzd.recursive;

/**
 * @Author ZZD
 * @Date 2020/7/24 19:05
 * @Email 1396896729@qq.com
 */
public class MiGong {
    private static int destinationX;
    private static int destinationY;
    private static int[][] miGong;
    public static void main(String[] args) {
        miGong= new int[10][10];
        for (int i = 0; i < miGong.length; i++) {
            if (i==0||i==miGong.length-1){
                for (int j = 0; j < miGong[i].length; j++) {
                    miGong[i][j] = 1;
                }
            }
            miGong[i][0] = 1;
            miGong[i][miGong.length-1] = 1;
        }
        miGong[3][1] = 1;
        miGong[3][2] = 1;
        miGong[3][3] = 1;
        destinationX = miGong[0].length-2;
        destinationY = miGong.length-2;
        for (int[] ints : miGong) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        findWay(miGong,1,1);
        System.out.println("===============找到的路-------------------------");
        for (int[] ints : miGong) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static boolean findWay(int[][] miGong,int x,int y){

        if (miGong[destinationX][destinationY]==2){
            return true;
        }
        if (miGong[x][y]==0){
            miGong[x][y] = 2;
           if (findWay(miGong,x+1,y)){
                return true;
            }else if (findWay(miGong, x, y+1)){
                return true;
            }else if (findWay(miGong, x-1, y)){

                return true;
            }else if (findWay(miGong, x, y+1)){
                return true;
            }else {
               miGong[x][y] = 3;
               return false;
           }
        }else {
            return false;
        }
    }
}
