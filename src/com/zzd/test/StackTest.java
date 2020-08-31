package com.zzd.test;

import com.zzd.stack.Calculator;

public class StackTest {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int compute = calculator.compute("1-22+3*4-1+12");
        System.out.println(compute);
    }
}
