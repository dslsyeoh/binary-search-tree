/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst;

import java.util.Arrays;
import java.util.List;

class StringBST extends GenericBST<String>
{
    StringBST()
    {
        super(String::equals, (source, target) -> source.compareToIgnoreCase(target) < 0, (source, target) -> source.compareToIgnoreCase(target) > 0);
    }

    @Override
    public void demo()
    {
        System.out.println("\n========================================= BEGIN BST FOR STRING DEMO =========================================");
        // construct binary search tree
        List<String> bst = Arrays.asList("this", "is", "demo", "binary", "search", "tree", "in", "string", "throne", "trex", "is");
        constructBST(bst);

        // print initial binary search tree
        print();

        System.out.println("=========================================== END BST FOR STRING DEMO ===========================================\n");
    }
}
