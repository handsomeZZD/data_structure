package com.zzd.tree;

/**
 * @Author ZZD
 * @Date 2020/8/8 13:32
 * @Email 1396896729@qq.com
 */
public class Node {
    private int id;
    private String name;
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Node leftNode;

    public Node rightNode;



    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if (this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if (this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }

    public void postOrder(){

        if (this.leftNode!=null){
            this.leftNode.postOrder();
        }
        System.out.println(this);
        if (this.rightNode!=null){
            this.rightNode.postOrder();
        }
    }

    public void midOrder(){

        if (this.leftNode!=null){
            this.leftNode.midOrder();
        }
        System.out.println(this);
        if (this.rightNode!=null){
            this.rightNode.midOrder();
        }

    }


}