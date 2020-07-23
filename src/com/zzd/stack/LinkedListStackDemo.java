package com.zzd.stack;


import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
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


class LinkedListStack {
    //栈的大小
    //栈顶位置
    private int top = -1;
    private LinkedList stack = new LinkedList<int[]>();


    //判空
    public boolean isEmpty() {

       return stack.isEmpty();
    }

    //压栈
    public void push(int v) {
        stack.addFirst(v);
        System.out.println("添加成功");
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！！");
        }
         return Integer.parseInt(stack.removeFirst().toString());
    }

    //遍历栈
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        Object[] array = stack.toArray();
        for (Object o : array) {
            System.out.println(Integer.parseInt(o.toString()));
        }
    }
}
