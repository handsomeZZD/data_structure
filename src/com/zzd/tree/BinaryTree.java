package com.zzd.tree;

/**
 * @Author ZZD
 * @Date 2020/8/8 12:44
 * @Email 1396896729@qq.com
 */
public class BinaryTree {
    private Node root;

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
    }

    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        }
    }

    public void addNode(Node node) {
        if (this.root == null) {
            root = node;
            return;
        }
        Node temp = root;
        while (true) {
            if (node.getId() == temp.getId()){
                System.out.println("添加失败-id已存在");
                return;
            }
            if (node.getId() > temp.getId()) {
                if (temp.rightNode == null) {
                    temp.rightNode = node;
                    return;
                }
                temp = temp.rightNode;
            }

            if (node.getId() < temp.getId()) {
                if (temp.leftNode == null) {
                    temp.leftNode = node;
                    return;
                }
                temp = temp.leftNode;
            }
        }

    }

}


