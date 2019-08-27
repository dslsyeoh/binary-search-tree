/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst.demo;

import com.dsl.bst.core.IntegerBST;
import com.dsl.bst.core.StringBST;

import java.util.Arrays;
import java.util.List;

public class BSTSearchDemo
{
    public static void main(String[] args)
    {
        searchStringBST();
        searchIntegerBST();
    }

    private static void searchStringBST()
    {
        StringBST stringBST = new StringBST();
        stringBST.initialize(Arrays.asList("this is sample string", "how are you guys", "test wild search?", "hello world", "hello, good morning", "trying to look for wild animal"));
        System.out.println("=========================================================== SEARCH RESULT ===========================================================\n");
        List<String> nonWSResult = stringBST.search("hello");
        List<String> wsResult = stringBST.search("wild", true);

        System.out.println("=========================================================== NON WILD SEARCH RESULT ===========================================================");
        System.out.println("Keyword: " + "hello");
        System.out.println("Result:");
        nonWSResult.forEach(System.out::println);
        System.out.println("=========================================================== NON WILD SEARCH RESULT ===========================================================\n");
        System.out.println("=========================================================== WILD SEARCH RESULT ===========================================================");
        System.out.println("Keyword: " + "wild");
        System.out.println("Result:");
        wsResult.forEach(System.out::println);
        System.out.println("=========================================================== WILD SEARCH RESULT ===========================================================\n");

        System.out.println("=========================================================== SEARCH RESULT ===========================================================\n");
    }

    private static void searchIntegerBST()
    {
        IntegerBST integerBST = new IntegerBST();
        integerBST.initialize();
        System.out.println("=========================================================== SEARCH RESULT ===========================================================\n");
        List<Integer> nonWSResult = integerBST.search(60);
        List<Integer> wsResult = integerBST.search(1, true);

        System.out.println("=========================================================== NON WILD SEARCH RESULT ===========================================================");
        System.out.println("Keyword: " + 60);
        System.out.println("Result:");
        nonWSResult.forEach(System.out::println);
        System.out.println("=========================================================== NON WILD SEARCH RESULT ===========================================================\n");
        System.out.println("=========================================================== WILD SEARCH RESULT ===========================================================");
        System.out.println("Keyword: " + 1);
        System.out.println("Result:");
        wsResult.forEach(System.out::println);
        System.out.println("=========================================================== WILD SEARCH RESULT ===========================================================");
    }
}
