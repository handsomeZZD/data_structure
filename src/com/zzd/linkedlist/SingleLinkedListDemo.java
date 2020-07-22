package com.zzd.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "大娃");
        Node node2 = new Node(2, "二娃");
        Node node3 = new Node(3, "三娃");
        Node node4 = new Node(4, "四娃");
       /*
        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node2);
        singleLinkedList.addNode(node3);
        singleLinkedList.addNode(node4);*/

       /* Node node2 = new Node(2, "二娃");
        Node node1 = new Node(1, "大娃");
        Node node4 = new Node(4, "四娃");
        Node node3 = new Node(3, "三娃");
        Node node5 = new Node(233, "沙瓦蒂卡");

        singleLinkedList.addByOrder(node5);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node4);

        singleLinkedList.update(new Node(2, "二十八娃"));
        singleLinkedList.update(new Node(6, "加大娃"));

        singleLinkedList.list();

        System.out.println("-------------------------------------------------");
        singleLinkedList.delete(233);
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);
        singleLinkedList.delete(4);
        System.out.println("-------------------------------------------------");

        singleLinkedList.list();*/

        singleLinkedList.addNodeRear(node3);
        singleLinkedList.addNodeRear(node1);
        singleLinkedList.addNodeRear(node2);
        singleLinkedList.addNodeRear(node4);
        singleLinkedList.list();
        System.out.println("----------------------查找单链表中倒数第k个节点-----------------------");
        Node nodeIndexRear = singleLinkedList.getNodeIndexRear(1);
        System.out.println(nodeIndexRear);

        System.out.println("----------------------反转链表-----------------------");
        singleLinkedList.reverse();

    }
}

class Node {
    public int no;  //编号
    public String name;//名字
    public Node next;//存放下一个节点

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                "" +
                '}';
    }
}

class SingleLinkedList {

    private Node head = new Node(0, "");

    public Node getHead() {
        return head;
    }

    //在尾部插入数据，循环遍历到最后一个位置 然后插入数据
    public void addNodeRear(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /*
        头插法
        1.判断链表是否为空。若为空直接将数据插入。
        2.若不为空，则插入的节点指向指向原来 头节点的所指向的位置，然后头节点指向插入的节点。
     */
    public void addNodeFront(Node node) {
        if (head.next == null) {
            head.next = node;
            return;
        }

        node.next = head.next;
        head.next = node;
    }

    /*
        打印链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！！");
            return;
        }
        Node temp = head.next;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /*
        按顺序的添加
        1.如果链表是空的添加到第一个位置。
        2.判断下一个元素是否比要添加的元素大，如果不比它大，继续遍历查找，否则将数据插入到这个元素跟下个元素之间
         node.next = temp.next;
         temp.next = node;
     */
    public void addByOrder(Node node) {
        Node temp = head;

        while (true) {
            if (temp.next == null) {
                temp.next = node;
                return;
            }

            if (temp.next.no > node.no) {
                break;
            }

            if (temp.next.no == node.no) {
                System.out.println(node.no + "元素已经存在");
                return;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    /*
        修改数据
        1.判空
        2.遍历查询，如果找到该元素。
            node.next = temp.next.next;
            temp.next = node;

     */
    public void update(Node node) {

        if (head.next == null) {
            System.out.println("链表为空。");
            return;
        }
        Node temp = head;
        while (true) {

            if (temp == null) {
                System.out.println("修改失败，没有该元素。");
                return;
            }
            if (temp.next.no == node.no) {
                node.next = temp.next.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }


    }

    /*
        删除元素
        temp.next = temp.next.next;
        将指向下个节点的指针，指向下个节点的下个节点
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("删除失败,列表为空！");
            return;
        }
        Node temp = head;

        while (true) {
            if (temp.next == null) {
                System.out.println("删除失败，未找到该元素。");
                return;
            }
            System.out.println(temp.next.no + "---------" + no);
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                return;
            }

            temp = temp.next;
        }
    }

    /*
        获取链表长度
     */
    public int getLength() {
        int length = 0;
        Node temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public Node getNodeIndexRear(int index) {
        //判断是否越界
        if (index < 1 || index > getLength()) {
            return null;
        }
        //除去表头
        Node temp = head.next;
        for (int i = 0; i < getLength() - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /*
    反转单链表
    1.
     */
    public void reverse() {
        if (head.next == null) {
            return;
        }

        Node temp1 = head;
        Node temp2 = head.next;
        Node temp3 = null;
        while (temp2 != null) {
            temp3 = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;

        }
        head.next.next = null;

        head.next = temp1;

        list();
    }
}
