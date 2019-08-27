/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst.demo;

import com.dsl.bst.core.IntegerBST;
import com.dsl.bst.core.StringBST;
import com.dsl.bst.logging.CustomLogger;

public class BSTDemo
{
    public static void main(String[] args)
    {
        CustomLogger.log("BST INTEGER DEMO", () -> new IntegerBST().demo());
        System.out.println("===================================================================================================\n");
        CustomLogger.log("BST STRING DEMO", () -> new StringBST().demo());
    }
}
