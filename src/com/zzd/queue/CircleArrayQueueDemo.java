package com.zzd.queue;

import java.util.Scanner;

/**
 * 使用数组来模拟队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
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
class CircleQueue{
    private int maxSize; //最大存储值
    private int front; //头节点
    private int rear; //尾节点
    private int[] arr;//实际存储数据的数组

    //初始化队列，传入队列的长度
    public CircleQueue(int arrMax){
        maxSize=arrMax;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    //判断是否满了
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    //判断是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //往队列添加数据，首先判断是否满了。如果没满将数据添加到下标为rear的位置。然后rear往后移动一个位置
    public void addQueue(int value){
        if (isFull()){
            System.out.println("队列满不能加入数据!");
            return;
        }
        arr[rear] = value;
        rear = (rear+1)%maxSize;
    }

    //从队列拿数据，首先判断是否为空。如果不是空的，把下标为front的值存入一个零时变量然后front后移，再返回数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("对列是空的!");
        }
        int temp = arr[front];
        front = (front+1)%maxSize;
        return temp;
    }

    //循环遍历队列 rear+maxSize-front)%maxSize 表示队列的有效元素个数
    public void show(){
        System.out.println("------------------");
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int i = front; i < front+((rear+maxSize-front)%maxSize); i++) {
                System.out.printf("arr[%d] ---- %d\n",i%maxSize,arr[i%maxSize]);
            }
        }
        System.out.println("------------------");
    }
    //获取队头
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("对列是空的!");
        }
        return arr[front];
    }
}