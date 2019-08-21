/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst;

import java.util.Arrays;
import java.util.List;

class IntegerBST extends GenericBST<Integer>
{
    IntegerBST()
    {
        super(Integer::equals, (source, target) -> source > target);
    }

    @Override
    public void demo()
    {
        System.out.println("\n========================================= BEGIN BST FOR INTEGER DEMO =========================================");

        // construct binary search tree
        List<Integer> bst = Arrays.asList(10, 1, 12, 5, 2, 11, 50, 30, 60, 29, 50, 70, 62, 1, 8, 6, 9, 7, 9, 10, 0);
        constructBST(bst);

        // print initial binary search tree
        System.out.println("================================= BEGIN PRINT INITIAL BINARY SEARCH TREE =================================");
        print();
        System.out.println("================================== END PRINT INITIAL BINARY SEARCH TREE ==================================");

        // insert node into binary search tree
        insert(72);

        // print binary search tree after insertions
        System.out.println("================================= BEGIN PRINT INSERTION BINARY SEARCH TREE =================================");
        print();
        System.out.println("================================== END PRINT INSERTION BINARY SEARCH TREE ==================================");

        // initialize inputs to validate node in binary search tree
        List<Integer> validateNodes = Arrays.asList(11, 60, 20, 21, 50, 30);

        // validate inputs from binary search tree
        validate(validateNodes);

        // initialize inputs to delete node in binary search tree
        List<Integer> deleteNodes = Arrays.asList(11, 60);

        // delete nodes in binary search tree
        delete(deleteNodes);

        // print binary search tree after deletions
        System.out.println("================================= BEGIN PRINT DELETION BINARY SEARCH TREE =================================");
        print();
        System.out.println("================================== END PRINT DELETION BINARY SEARCH TREE ==================================");

        // print binary search tree from specific node
        System.out.println("================================= BEGIN PRINT SPECIFIC NODE IN BINARY SEARCH TREE =================================");
        print(12);
        System.out.println("================================== END PRINT SPECIFIC NODE IN  BINARY SEARCH TREE ==================================");

        System.out.println("=========================================== END BST FOR INTEGER DEMO ===========================================\n");
    }
}
