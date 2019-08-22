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
        // construct binary search tree
        List<Integer> bst = Arrays.asList(10, 1, 12, 5, 2, 11, 50, 30, 60, 29, 50, 70, 62, 1, 8, 6, 9, 7, 9, 10, 0);
        CustomLogger.log("INITIAL BTS", () -> constructBST(bst));

        // print initial binary search tree
        CustomLogger.log("PRINT INITIAL BST", this::print);

        // insert node into binary search tree
        CustomLogger.log("INSERT 72 INTO BST", () -> insert(72));


        // print binary search tree after insertions
        CustomLogger.log("PRINT BST AFTER INSERT", this::print);

        // initialize inputs to validate node in binary search tree
        List<Integer> validateNodes = Arrays.asList(11, 60, 20, 21, 50, 30);

        // validate inputs from binary search tree
        CustomLogger.log("VALIDATE BST", () -> validate(validateNodes));

        // initialize inputs to delete node in binary search tree
        List<Integer> deleteNodes = Arrays.asList(11, 60);

        // delete nodes in binary search tree
        CustomLogger.log("DELETE NODE IN BST", () -> delete(deleteNodes));

        // print binary search tree after deletions
        CustomLogger.log("PRINT BST AFTER DELETE", this::print);

        // print binary search tree from specific node
        CustomLogger.log("PRINT SPECIFIC NODE IN BST", () -> print(12));
    }
}
