package com.zzd.test;

import com.zzd.tree.huffmancode.HuffmanCode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @Author ZZD
 * @Date 2020/8/24 23:05
 * @Email 1396896729@qq.com
 */
public class HuffmanCodeTest {
    public static void main(String[] args) {
        String str = "aaaaab";
        byte[] zip = HuffmanCode.huffmanZip(str.getBytes());
        Map<Byte, String> huffmanCodes = HuffmanCode.getHuffmanCodes(str.getBytes());

        System.out.println(huffmanCodes);

        byte[] decode = HuffmanCode.decode(huffmanCodes, zip);

        System.out.println(new String(decode));


    }
}
