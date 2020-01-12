/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.bst.demo;

import com.dsl.bst.core.TestBST;

public class TestDemo
{
    public static void main(String[] args)
    {
        TestBST testBST = new TestBST();
        testBST.initialize();
        testBST.delete();
        testBST.print();
    }
}
