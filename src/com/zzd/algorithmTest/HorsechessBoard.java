package com.zzd.algorithmTest;

import java.awt.*;
import java.util.ArrayList;

/**
 * @Author ZZD
 * @Date 2020/8/31 16:29
 * @Email 1396896729@qq.com
 */
public class HorsechessBoard {
    private static int X; // 表示列
    private static int Y; // 表示行
    private static boolean visited[]; // 是否被访问
    private static boolean finished; // 是否全部完成

    // 进行行走
    public static void traversal(int[][] arr, int row, int col, int step) {
        arr[row][col] = step;
        visited[row * X + col] = true;// 初始位置标记为已访问
        // 获取下一步集合
        ArrayList<Point> ps = next(new Point(col, row));
        // 遍历集合
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            // 判断该点是否访问过
            if (!visited[p.y * X + p.x]) { // 没有访问过
                traversal(arr, p.y, p.x, step+1);
            }
        }
        if (step < X * Y && !finished) {
            arr[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }

    // 根据当前位置计算还有哪些位置可以走
    public static ArrayList<Point> next(Point cutPoint) {
        ArrayList<Point> ps = new ArrayList<Point>();
        Point p1 = new Point();
        // 判断是否可以走下一个位置
        if ((p1.x = cutPoint.x - 2) >= 0 && (p1.y = cutPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cutPoint.x - 1) >= 0 && (p1.y = cutPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cutPoint.x + 1) < X && (p1.y = cutPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cutPoint.x + 2) < X && (p1.y = cutPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cutPoint.x + 2) < X && (p1.y = cutPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cutPoint.x + 1) < X && (p1.y = cutPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cutPoint.x - 1) >= 0 && (p1.y = cutPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cutPoint.x - 2) >= 0 && (p1.y = cutPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public static void main(String[] args) {
        X = 6;
        Y = 6;
        int row = 1;
        int col = 1;
        int[][] arr = new int[X][Y];
        visited = new boolean[X * Y];
        System.out.println("开始");
        long start = System.currentTimeMillis();
        traversal(arr, row-1, col-1,1);
        long end = System.currentTimeMillis();
        System.out.println("耗时 = "+ (end-start)+" 毫秒");
        for(int[] rows:arr) {
            for(int step :rows) {
                System.out.print(step+"\t");
            }
            System.out.println();
        }
        System.out.println("结束");
    }
}