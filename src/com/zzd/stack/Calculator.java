package com.zzd.stack;

import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {
    //要处理的字符串 类式 1-2+3*4
    private String str;
    //用于匹配字符串中的数字
    private Pattern isNum = Pattern.compile("[0-9]");
    //存储数的栈
    private Stack num = new Stack<>();
    //存储操作符的栈
    private Stack operator = new Stack<>();
    //存储数字，当数字超过一位时拼接数字
    private StringBuffer temp = new StringBuffer();

    public int compute(String str) {
        //遍历传过来的字符串
        for (int i = 0; i < str.length(); i++) {
            String strTemp = str.substring(i, i + 1);
            //判断是否是数字。如果是数字加入到temp中
            if (isNum.matcher(strTemp).matches()) {
                temp.append(strTemp);
                if (i==str.length()-1){
                    num.push(temp.toString());
                }
                continue;
            }
            //如果不是数字将刚才拼接的数字字符串添加到num栈中。
            num.push(temp.toString());
            //将temp清空
            temp = temp.delete(0,temp.length());
            //如果操作符栈中是空的将操作符加到栈中
            if (operator.isEmpty()) {
                operator.push(strTemp.toString());
                continue;
            }

            //比较操作符的优先级，如果小于等于当前优先级 直接计算从num栈弹出两个数字，ope栈中栈顶的操作符进行计算，然后将计算的值从新放入num栈中
            if (priority(strTemp) <= priority(operator.peek().toString())) {
                num.push(calculator(Integer.parseInt(num.pop().toString()), Integer.parseInt(num.pop().toString()), operator.pop().toString()));
            }

            //将操作符加到ope栈中
            operator.push(strTemp.toString());

        }
        //如果操作符栈不为空。依次弹栈计算。
        while (!operator.isEmpty()){
            num.push(calculator(Integer.parseInt(num.pop().toString()), Integer.parseInt(num.pop().toString()), operator.pop().toString()));
        }
        //把结果返回
        return Integer.parseInt(num.pop().toString());
    }

    //计算
    private int calculator(int num1, int num2, String ope) {
        switch (ope) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
            default:
                throw new RuntimeException("运算符有误，计算失败");
        }
    }

    //比较操作符的优先级
    private int priority(String ope) {
        switch (ope) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                throw new RuntimeException("运算符有误");
        }
    }
}
