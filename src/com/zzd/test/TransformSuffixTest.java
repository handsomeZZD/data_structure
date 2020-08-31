package com.zzd.test;

import com.zzd.stack.RPNCalculator;
import com.zzd.stack.TransformSuffix;

import java.util.List;

public class TransformSuffixTest {
    public static void main(String[] args) {
        TransformSuffix transformSuffix = new TransformSuffix();
        //2*(9+6/3-5)+4  后缀 2 9 6 3 / + 5 - * 4 +
        System.out.println("转换前:");
        List<String> list = transformSuffix.transform("2*(9+6/3-5)+4");
        System.out.println("转换后:");
        for (String s : list) {
            System.out.print(s);
        }
        RPNCalculator calculator = new RPNCalculator();

        double v = calculator.Calculator(list);

        System.out.println();
        System.out.println("---------------------");
        System.out.println("使用逆波兰计算结果为:"+v);

    }
}
