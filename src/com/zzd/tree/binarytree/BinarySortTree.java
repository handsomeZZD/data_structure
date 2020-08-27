package com.zzd.tree.binarytree;

/**
 * @Author ZZD
 * @Date 2020/8/26 15:44
 * @Email 1396896729@qq.com
 *
 * 二叉排序树
 */
public class BinarySortTree {
    //根节点
    Node root = null;

    //添加节点，
    public void add(int value) {
        if (root != null) {
            root.add(new Node(value));
            return;
        }
        root = new Node(value);


    }
    //中序遍历平衡二叉树
    public void infixOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        root.infixOrder();
    }

    //搜索节点
    public Node search(int value) {
        return root.search(value);

    }
    //搜索父节点
    public Node searchParent(int value) {
        return root.searchParent(value);
    }
    /*
           删除分为3种情况
           1.删除的是叶子节点，寻找父节点，判断是左还是右子节点。然后直接删除。
           2.删除的只有一个子节点。找到其父元素首先判断是左还是右节点，然后直接将父节点的指向。被删除节点的子节点。
           3.删除的节点有两个子节点，找到被删除的节点的 左子树（右子树) 找到其中最大(小)的节点。将其数据直接移动到被删除节点的位置即可。
     */
    public void delete(int value) {
        if (root == null) {
            return;
        }
        Node node = search(value);
        Node parentNode = searchParent(value);
        //是否为叶子节点
        if (node.left == null && node.right == null) {
            if (node.value < parentNode.value) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
            return;
        }
        //是否有两个叶子节点
        if (node.left != null && node.right != null) {
            Node min = root.searchMin(node.right);
            delete(min.value);
            node.value = min.value;
            return;
        }

        //一个节点
        if (node.left==null) {
            if (parentNode==null) {
                root = node.right;
                return;
            }
            if (node.value < parentNode.value) {
                parentNode.left =node.right;
            } else {
                parentNode.right = node.right;
            }
        }else {
            if (parentNode==null) {
                root = node.left;
                return;
            }
            if (node.value < parentNode.value) {
                parentNode.left =node.left;
            } else {
                parentNode.right = node.left;
            }

        }

    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    //添加节点，递归查找位置
    public void add(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }

        }


    }
    //搜索。
    public Node search(int value) {
        if (this.value == value) {
            return this;
        }

        if (value < this.value) {
            if (this.left != null) {
                return this.left.search(value);
            }
        } else {
            if (this.right != null) {
                return this.right.search(value);
            }
        }

        return null;
    }
    //搜索父节点,从根节点开始。
    public Node searchParent(int value) {
        //找到父节点
        if ((this.left != null && value == this.left.value) || (this.right != null && value == this.right.value)) {
            return this;
        }
        if (this.left != null && value < this.value) {
            return this.left.searchParent(value);
        }
        if (this.right != null && value >= this.value) {
            return this.right.searchParent(value);
        }

        return null;

    }

    //寻找最小的节点。一直往右
    public Node searchMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(value);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
