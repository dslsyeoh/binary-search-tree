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
        super((source, target) -> source.compareToIgnoreCase(target) == 0, (source, target) -> source.compareToIgnoreCase(target) > 0);
    }

    @Override
    public void demo()
    {
        System.out.println("\n========================================= BEGIN BST FOR STRING DEMO =========================================");
        // construct binary search tree
        List<String> bst = Arrays.asList("this", "is", "demo", "binary", "search", "tree", "in", "string", "throne", "trex", "is");
        constructBST(bst);

        // print initial binary search tree
        System.out.println("================================= BEGIN PRINT INITIAL BINARY SEARCH TREE =================================");
        print();
        System.out.println("================================== END PRINT INITIAL BINARY SEARCH TREE ==================================");

        // insert node into binary search tree
        insert("zebra");

        // print search tree after insertions
        System.out.println("================================= BEGIN PRINT INSERTION BINARY SEARCH TREE =================================");
        print();
        System.out.println("================================== END PRINT INSERTION BINARY SEARCH TREE ==================================");

        // initialize inputs to validate node in binary search tree
        List<String> validateNodes = Arrays.asList("demo", "binary", "gamer", "how", "throne", "trex");

        // validate inputs from binary search tree
        validate(validateNodes);

        // initialize inputs to delete node in binary search tree
        List<String> deleteNodes = Arrays.asList("throne", "trex", "search");

        // delete nodes in binary search tree
        delete(deleteNodes);

        // print search tree after deletions
        System.out.println("================================= BEGIN PRINT DELETION BINARY SEARCH TREE =================================");
        print();
        System.out.println("================================== END PRINT DELETION BINARY SEARCH TREE ==================================");

        // print binary search tree from specific node
        System.out.println("================================= BEGIN PRINT SPECIFIC NODE IN BINARY SEARCH TREE =================================");
        print("demo");
        System.out.println("================================== END PRINT SPECIFIC NODE IN  BINARY SEARCH TREE ==================================");

        System.out.println("=========================================== END BST FOR STRING DEMO ===========================================\n");
    }
}
