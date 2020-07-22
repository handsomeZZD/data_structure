package com.zzd.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        Node2 node1 = new Node2(1, "大娃");
        Node2 node2 = new Node2(2, "二娃");
        Node2 node3 = new Node2(3, "三娃");
        Node2 node4 = new Node2(4, "四娃");
        Node2 node5 = new Node2(5, "五娃");
        Node2 node6 = new Node2(6, "六娃");
        Node2 node7 = new Node2(7, "七娃");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("-----添加到尾部----");
        doubleLinkedList.addNodeRear(node1);
        doubleLinkedList.addNodeRear(node2);
        doubleLinkedList.addNodeRear(node3);
        doubleLinkedList.addNodeRear(node4);
       doubleLinkedList.addNodeRear(node5);
        doubleLinkedList.addNodeRear(node6);
        doubleLinkedList.addNodeRear(node7);
        doubleLinkedList.list();
        System.out.println("---------修改链表---------");
        doubleLinkedList.update(new Node2(4, "250娃"));
        doubleLinkedList.list();
        System.out.println("------删除链表中的某项-------");
  /*      doubleLinkedList.delete(5);
        doubleLinkedList.delete(4);
        doubleLinkedList.delete(4);
        doubleLinkedList.list();*/
        System.out.println("------有序的插入-------");
      /*  doubleLinkedList.addByOrder(node2);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node6);
        doubleLinkedList.addByOrder(node7);
        doubleLinkedList.addByOrder(node5);*/
        doubleLinkedList.list();
        System.out.println("--------头插法----------");
      /*  doubleLinkedList.addNodeFront(node1);
        doubleLinkedList.addNodeFront(node2);
        doubleLinkedList.addNodeFront(node3);
        doubleLinkedList.addNodeFront(node4);
        doubleLinkedList.addNodeFront(node5);
        doubleLinkedList.addNodeFront(node6);
        doubleLinkedList.addNodeFront(node7);*/
        doubleLinkedList.list();
        System.out.println("--------反转----------");
        doubleLinkedList.reverse();
    }
}

class Node2 {
    public int no;  //编号
    public String name;//名字
    public Node2 next;//存放下一个节点
    public Node2 prev;//存放前一个节点

    public Node2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                "" +
                '}';
    }
}

class DoubleLinkedList {
    //初始化单链表
    private Node2 head = new Node2(0, "");


    //遍历打印
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！！");
            return;
        }
        Node2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /*
    尾插法
    1.遍历到链表最后一个，在后面插入
     */
    public void addNodeRear(Node2 node2) {
        Node2 temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node2;
                node2.prev = temp;
                return;
            }
            temp = temp.next;
        }


    }

    /*
        头插法

     */
    public void addNodeFront(Node2 node2){
        if (head.next == null){
            addNodeRear(node2);
            return;
        }
        head.next.prev = node2;
        node2.next = head.next;
        node2.prev = head;
        head.next = node2;
    }

    /*
    有顺序的插入
    1.如果是空链表则插入到第一个位置。否则循环遍历，将数据插入到比下个数据小，比当前数据大之间的位置。
     */
    public void addByOrder(Node2 node2) {
        if (head.next == null) {
            addNodeRear(node2);
            return;
        }
        Node2 temp = head;
        while (true) {
            if (temp.next == null) {
                addNodeRear(node2);
                return;
            }
            if (temp.next.no > node2.no) {
                temp.next.prev = node2;
                node2.next = temp.next;
                node2.prev = temp;
                temp.next = node2;
                return;
            }
            temp = temp.next;
        }
    }

    /*
    修改数据
     */
    public void update(Node2 node2) {
        if (head.next == null) {
            System.out.println("链表为空！无法修改");
            return;
        }
        Node2 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("链表中没有该元素，修改失败");
                return;
            }
            if (temp.no == node2.no) {
                if (temp.next == null) {
                    temp.prev.next = node2;
                    node2.prev = temp.prev;
                    return;
                }
                temp.prev.next = node2;
                temp.next.prev = node2;
                node2.next = temp.next;
                node2.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }

    }

    /*
    删除
     */
    public void delete(int no) {
        Node2 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("删除失败未找到该元素。");
                return;
            }

            if (temp.no == no) {
                if (temp.next == null) {

                    temp.prev.next = null;
                    temp.prev = null;
                    return;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }

    }

    /*
    双链表反转，只需借助两个指针即可
    1.首先判断，如果链表为空，或者只有一个数据，不用反转直接返回
    2.遍历链表，使用头插法将数据重新插入到原来的链表。当然为了使链表不断开，要提前将插入节点的下一个节点保存起来
    3.由于反转后第一个节点就是链表最后一个节点，所以要第一个节点的next置为空。
     */
    public void reverse() {
        if (head.next == null || head.next.next == null) {
            return;
        }
        Node2 temp1 = head.next.next;
        head.next.next = null;
        Node2 temp2;

        while (temp1 != null) {

          temp2 = temp1.next;
          addNodeFront(temp1);
          temp1 = temp2;

        }
        list();
    }
}