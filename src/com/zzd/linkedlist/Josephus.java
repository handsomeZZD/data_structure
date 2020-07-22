package com.zzd.linkedlist;

public class Josephus {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.compute(1,2,6);
    }
}

/*

 */
class Person {
    public int no;
    public Person next;

    public Person(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Person{" +
                "no=" + no +
                '}';
    }
}

class CircleSingleLinkedList {
    private Person first;
    private Person cur;

    //设置约瑟夫环的最大数
    public void add(int max) {
        if (max < 1) {
            System.out.println("人数错误，人数至少要大于1");
        }

        for (int i = 1; i <= max; i++) {
            if (i == 1) {
                first = new Person(1);
                first.next = first;
                cur = first;
                continue;
            }
            cur.next = new Person(i);
            cur = cur.next;

        }
        cur.next = first;
    }

    // 显示约瑟夫环的内容
    public void show() {
        if (first==null){
            System.out.println("没有数据~");
        }
        cur = first;
        while (true) {
            System.out.println(cur);
            cur = cur.next;
            if (cur==first){
                return;
            }
        }
    }
    /*
         计算最后一个出圈的人
     */
    public void compute(int start, int stepSize,int maxSize){
        //判断输入的值合法性
        if (stepSize<1 || start<1 || start>maxSize){
            System.out.println("输入有误");
            return;
        }
        System.out.println(" 环大小为 "+maxSize+"  从第 "+start+" 开始计报 "+" 每次报 "+stepSize+" 个数");
        System.out.println("--------出圈顺序-----------");
        //添加约瑟夫环的最大数
        add(maxSize);
        //将first移动到开始报数的那个人
        for (int i = 0; i < start-1; i++) {
            first = first.next;
        }
        //每次移动stepSize-2的距离，stepSize-1 既为出圈的人。
        //所以stepSize-2直接指向stepSize即可实现出圈。
        Person temp;
        while (true){
            for (int i = 0; i < stepSize-2; i++) {
                first = first.next;
            }
            temp = first;
            System.out.println("出圈的为"+temp.next.no);
            first = first.next.next;
            temp.next = first;

            //当剩最后一个节点的时候，即可结束循环
            if (temp == first){
                System.out.println("最后出圈的为"+temp.no);
                return;
            }
        }

    }
}