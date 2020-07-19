package com.zzd.queue;

import java.util.Scanner;

/**
 * 使用数组来模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("s:显示队列");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从获取一个数据");
            System.out.println("h:显示队列的头部");
            System.out.println("e:退出程序");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输入要存的值：");
                    int v = scanner.nextInt();
                    queue.addQueue(v);
                    break;
                case 'g':
                    try {
                        System.out.println(queue.getQueue());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(queue.headQueue());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    System.out.println("退出程序！！！");
                    return;
            }
        }

    }
}
class ArrayQueue{
    private int maxSize; //最大存储值
    private int front; //头节点
    private int rear; //尾节点
    private int[] arr;//实际存储数据的数组

    //初始化队列，传入队列的长度
    public ArrayQueue(int arrMax){
        maxSize=arrMax;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断是满了
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //判断是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //往队列添加数据，首先判断是否满了。如果没满将数据添加到下标为rear的位置。然后rear++ 往后移动一个位置
    public void addQueue(int value){
        if (isFull()){
            System.out.println("队列满不能加入数据!");
            return;
        }
        arr[++rear] = value;
    }

    //从队列拿数据，首先判断是否为空。如果不是空的，把下标为front的值返回 front后移
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("对列是空的!");
        }
        return arr[++front];
    }

    //循环遍历队列
    public void show(){
        System.out.println("------------------");
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("------------------");
    }
    //获取队头
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("对列是空的!");
        }
        return arr[front+1];
    }
}