package com.zzd.tree.huffmancode;

import java.util.*;

/**
 * @Author ZZD
 * @Date 2020/8/24 22:41
 * @Email 1396896729@qq.com
 */
public class HuffmanCode {

    public static byte[] huffmanZip(byte[] bytes) {


        Map<Byte, String> huffmanCodes = getHuffmanCodes(bytes);

        return zip(bytes, huffmanCodes);
    }

    /**
     * @return 得到哈夫曼树的权值数组
     * @params 传入bytes
     */
    private static List<Node> getWeight(byte[] bytes) {

        HashMap<Byte, Integer> map = new HashMap<>();
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历数组。获取每个元素出现的次数。当中哈夫曼树的权值
        for (Byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }
        //将对应的权值存到node数组中
        for (Byte key : map.keySet()) {
            nodes.add(new Node(key, map.get(key)));
        }

        return nodes;
    }

    /**
     * @return 得到一个哈夫曼树的root节点
     * @params 传入哈夫曼树的权值数组
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        if (nodes.size() == 0 || nodes == null) {
            throw new RuntimeException("创建哈夫曼树失败，节点为空。");
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            //取出最小的两位将其组合一个新的二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.getWeight() + rightNode.getWeight());

            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            //将其从数组中移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //把新的节点放入数组中。
            nodes.add(parent);
        }
        /*返回根节点*/
        return nodes.get(0);
    }

    static HashMap<Byte, String> huffmanCode = new HashMap<>();


    /**
     * @return
     * @params 使用递归创建哈夫曼编码
     */
    private static void createHuffmanCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder str = new StringBuilder(stringBuilder);

        str.append(code);

        if (node != null) {
            if (node.getData() == null) {
                createHuffmanCode(node.getLeft(), "0", str);
                createHuffmanCode(node.getRight(), "1", str);
            } else {
                huffmanCode.put(node.getData(), str.toString());
            }

        }
    }


    public static Map<Byte, String> getHuffmanCodes(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Node> nodes = getWeight(bytes);
        if (nodes.size() == 1) {
          huffmanCode.put(nodes.get(0).getData(),"0");
          return huffmanCode;
        }
        Node huffmanTree = createHuffmanTree(nodes);
        createHuffmanCode(huffmanTree, "", stringBuilder);
        return huffmanCode;
    }

    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte b : bytes) {
            stringBuilder.append(huffmanCode.get(b));
        }
        int len = stringBuilder.length() % 8 == 0 ? stringBuilder.length() / 8 : stringBuilder.length() / 8 + 1;
        byte[] by = new byte[len];
        int index = 0;
        byte temp;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length()) {
                by[index++] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
            } else {
                by[index++] = (byte) Integer.parseInt(stringBuilder.substring(i, i + 8), 2);
            }
        }

        return by;

    }

    private static String byteToBinaryString(byte b, boolean isEnd) {
        if (isEnd) {
            String s = Integer.toBinaryString(b);
            if (s.length() > 8) {
                s = s.substring(s.length() - 8);
            }
            return s;
        }
        String str = Integer.toBinaryString(b | 256);

        return str.substring(str.length() - 8);

    }

    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag;
        for (int i = 0; i < huffmanBytes.length; i++) {

            flag = i == huffmanBytes.length - 1;

            stringBuilder.append(byteToBinaryString(huffmanBytes[i], flag));
        }
        ArrayList<Byte> list = new ArrayList<>();
        HashMap<String, Byte> map = new HashMap<>();
        for (Byte b : huffmanCodes.keySet()) {
            map.put(huffmanCodes.get(b), b);
        }
        StringBuilder temp = new StringBuilder();
        int index = 0;
        while (index < stringBuilder.length()) {

            if (map.get(temp.toString()) != null) {
                list.add(map.get(temp.toString()));
                temp.delete(0, temp.length());
            }
            temp.append(stringBuilder.charAt(index++));
        }
        list.add(map.get(temp.toString()));

        byte[] result = new byte[list.size()];

        int i = 0;
        for (Byte b : list) {
            result[i++] = b;
        }
        return result;
    }
}

class Node implements Comparable {
    private Byte data;
    private int weight;
    private Node left;
    private Node right;

    public Byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Node n = (Node) o;
        return this.weight - n.weight;
    }
}
