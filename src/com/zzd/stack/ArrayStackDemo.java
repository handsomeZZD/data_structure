package com.zzd.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        System.out.println("show : 展示栈中的数据");
        System.out.println("pop : 出栈");
        System.out.println("push : 压栈");
        System.out.println("exit : 退出");
        while (true){
            String key = scanner.next();
            switch (key){
                case "show":
                    stack.show();
                    break;

                case "pop":
                    try {
                        System.out.println(stack.pop());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("输入要添加的数据：");
                    int v = scanner.nextInt();
                    stack.push(v);
                    break;
                case "exit":
                    return;
            }
        }
    }
}


class ArrayStack {
    //栈的大小
    private int maxSize;
    //栈顶位置
    private int top = -1;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //判断是否满了,top在栈顶时栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判空
    public boolean isEmpty() {
        return top == -1;
    }

    //压栈
    public void push(int v) {
        if (isFull()) {
            System.out.println("栈满了");
            return;
        }
        stack[++top] = v;
        System.out.println("添加成功");
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！！");
        }
        return stack[top--];
    }

    //遍历栈
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
