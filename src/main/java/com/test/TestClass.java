package com.test;

import java.text.NumberFormat;

public class TestClass {
    public static void main(String[] args) {
        String formattedAmount = NumberFormat.getCurrencyInstance().format(305);
        System.out.println(formattedAmount);
    }
    }

