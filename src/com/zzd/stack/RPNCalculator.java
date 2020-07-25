package com.zzd.stack;

import java.util.List;
import java.util.Stack;

/**
 * @Author ZZD
 * @Date 2020/7/24 15:04
 * @Email 1396896729@qq.com
 */
public class RPNCalculator {
    //传入一个list类型的 后缀表达式
    public double Calculator(List<String> expressionSuffix) {
        //创建一个栈 用于保存数据
        Stack<String> stack = new Stack<String>();
        //遍历传过来的list集合
        for (int i = 0; i < expressionSuffix.size(); i++) {
            //判断是否是计算操作符。如果是弹出栈中的两个元素然后进行计算。
            if (this.isOperator(expressionSuffix.get(i))) {
                double d = this.compute(Double.parseDouble(stack.pop()), Double.parseDouble(stack.pop()), expressionSuffix.get(i));

                //计算完的结果重新，放到栈中
                stack.push(Double.toString(d));
                continue;
            }
            //如果是不是计算符，直接入栈
            stack.push(expressionSuffix.get(i));
        }
        //遍历完返回栈中最后一个元素，既为最终答案
        return Double.parseDouble(stack.pop());
    }

    //判断是否是操作符
    private boolean isOperator(String v) {
        if (v.equals("(") || v.equals(")") || v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/")) {
            return true;
        }
        return false;
    }

    //计算结果
    private double compute(double v1, double v2, String ope) {
        switch (ope) {
            case "+":
                return v1 + v2;
            case "-":
                return v2 - v1;
            case "*":
                return v1 * v2;
            case "/":
                return v2 / v1;

            default:
                throw new RuntimeException("运算符有误");
        }
    }
}
