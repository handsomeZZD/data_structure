package com.zzd.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/*
    中缀表达式转后缀
 */

public class TransformSuffix {

    public List<String> transform(String expression) {
        System.out.println(expression);
        //匹配数字或者小数点
        Pattern pattern = Pattern.compile("[0-9]|\\.");
        //存储零时转好的中缀表达式
        List<String> listInfix = new ArrayList<String>();
        //存储转完的后缀表达式
        List<String> listSuffix = new ArrayList<String>();
        Stack<String> operator = new Stack<String>();
        //如果有多个数字，使用stringBuffer进行拼接
        StringBuffer str = new StringBuffer();


        //遍历字符串 把字符串转成数组方便后面操作。
        //1.遇到数字放到str里面 方便拼接
        for (int i = 0; i < expression.length(); i++) {
            //每次遍历一位
            String temp = expression.substring(i, i + 1);
            //判断是否是数字或者小数点
            if (pattern.matcher(temp).matches()) {
                str.append(temp);
                if (i == expression.length() - 1) {
                    listInfix.add(str.toString());
                }
                continue;
            }
            //判断str中有无数字如果有再添加。防止添加到空字符串
            if (str.length()!=0){
                listInfix.add(str.toString());
            }
            //清空字符串
            str.delete(0, str.length());
            //如果是操作符直接添加到数组中
            if (isOperator(temp)) {
                listInfix.add(temp);
            }
        }

        /*
            遍历刚才准备好的数组将数组中的中缀表达式转换成后缀表达式。
         */
        for (int i = 0; i < listInfix.size(); i++) {
            //每次读取一个元素
            String e = listInfix.get(i);
            //判断是否是操作符
            if (this.isOperator(e)) {

                //如果操作符栈是空的直接push进去
                if (operator.isEmpty()) {
                    operator.push(e);
                    continue;
                }
                //如果是左括号push
                if (e.equals("(")) {
                    operator.push(e);
                    continue;
                }
                //如果是右括号将操作符栈中的元素pop到右元素的位置
                if (e.equals(")")) {
                    while (!operator.peek().equals("(")) {
                        listSuffix.add(operator.pop());
                    }
                    operator.pop();
                    continue;
                }
                //如果当前的操作符优先级比栈顶优先级高 直接push到栈中
                if (priority(e) > priority(operator.peek())) {
                    operator.push(e);
                    continue;
                }
                //如果当前操作符优先级比栈顶操作符小于或者等于。弹出栈中的操作符直达碰到等级比他高的操作符
                while (true) {
                    if (operator.isEmpty()) {
                        break;
                    }
                    if (operator.peek().equals("(")){
                        break;
                    }


                    if (priority(e) <= priority(operator.peek())) {
                        listSuffix.add(operator.pop());
                    }

                }

                operator.add(e);
            }
            //如果不是操作符直接将元素添加到数组中
            if (!isOperator(e)) {
                listSuffix.add(e);
            }




        }

        //遍历完数组，直接将栈中的所有元素弹出
        while (true) {
            if (operator.isEmpty()) {
                break;
            }
            listSuffix.add(operator.pop());

        }
        //返回最终的结果
        return listSuffix;
    }



    /*
            判断是不是操作符
     */
    private boolean isOperator(String v) {
        if (v.equals("(") || v.equals(")") || v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/")) {
            return true;
        }
        return false;
    }

    /*
            判断操作符的优先级
     */
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
            case "(":
                return 0;
            case ")":
                return 0;
            default:
                throw new RuntimeException("运算符有误");
        }
    }
}
