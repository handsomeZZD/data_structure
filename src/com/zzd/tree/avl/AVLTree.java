package com.zzd.tree.avl;

/**
 * @Author ZZD
 * @Date 2020/8/26 15:44
 * @Email 1396896729@qq.com
 * <p>
 * avl树
 */
public class AVLTree {
    //根节点
    Node root = null;

    //树高
    public int height() {
        return root == null ? 0 : root.height();
    }

    //根节点开始的左子树高度
    public int leftHeight() {
        return root == null ? 0 : root.leftHeight();
    }
    //根节点开始的右子树高度
    public int rightHeight() {
        return root == null ? 0 : root.rightHeight();
    }

    /**
     * LL 左旋处理树不平衡的情况
     * 1）记录不平衡结点的左子结点
     * 2）将左子结点的右子结点作为不平衡结点的左子结点
     * 3）将不平衡结点作为其左子结点的右子结点
     * 4）将不平衡结点的左子结点作为当前树的根结点
     */
    public Node leftRotate(Node node) {
        //记录不平衡结点的左子结点
        Node nodeLeft = node.left;
        //将左子结点的右子结点作为不平衡结点的左子结点
        node.left = nodeLeft.right;
        //将不平衡结点作为其左子结点的右子结点
        nodeLeft.right = node;
        //将不平衡结点的左子结点作为当前树的根结点
        return nodeLeft;
    }

    //右旋转类似上面
    public Node rightRotate(Node node) {
        Node rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;

        return rightNode;
    }

    /**
     * LR 左右旋转：由于在左子树的右子树上插入元素导致失衡，所以称为LR旋转
     * 步骤：
     * 1）可以拆分为一次对失衡结点的左子结点的右旋操作
     * 2）之后进行对失衡结点的一次左旋操作
     */
    public Node leftRightRotate(Node node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    //RL 旋转类似上面的
    public Node rightLeftRotate(Node node) {
        node.right = rightRotate(node.left);
        return leftRotate(node);
    }

    //添加节点，
    public void add(int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        root.add(new Node(value));

        //添加完判断当前树是否平衡不平衡进行调整
        if (root.leftHeight() - root.rightHeight() > 1) {
            //如果插入的结点数据大于失衡结点的左子树的值，证明该结点是在失衡结点的左子树的右子树插入，需要左旋右旋
            if (value > root.left.value) {
                root = leftRightRotate(root);

            } else {
                //否则证明插入的数据位于失衡结点的左子树的左子树
                root = leftRotate(root);
            }
            return;
        }

        if (root.rightHeight() - root.leftHeight() > 1) {
            //如果插入的结点数据小于失衡结点的右子树的值，证明该节点是在失衡结点的右子树的左子树插入，需要右旋左旋
            if (value < root.right.value) {
                root = rightLeftRotate(root);
            } else {
                //否则证明插入的数据位于失衡结点的右子树的右子树
                root = rightRotate(root);
            }
        }


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
        if (node.left == null) {
            if (parentNode == null) {
                root = node.right;
                return;
            }
            if (node.value < parentNode.value) {
                parentNode.left = node.right;
            } else {
                parentNode.right = node.right;
            }
        } else {
            if (parentNode == null) {
                root = node.left;
                return;
            }
            if (node.value < parentNode.value) {
                parentNode.left = node.left;
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

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        return left == null ? 0 : left.height();
    }

    public int rightHeight() {
        return right == null ? 0 : right.height();
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
