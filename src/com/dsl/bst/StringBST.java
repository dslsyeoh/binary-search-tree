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
        // construct binary search tree
        List<String> bst = Arrays.asList("this", "is", "demo", "binary", "search", "tree", "in", "string", "throne", "trex", "is");
        CustomLogger.log("INITIAL BTS", () -> constructBST(bst));

        // print initial binary search tree
        CustomLogger.log("PRINT INITIAL BST", this::print);

        // insert node into binary search tree
        CustomLogger.log("INSERT zebra INTO BST", () -> insert("zebra"));

        // print search tree after insertions
        CustomLogger.log("PRINT BST AFTER INSERT", this::print);

        // initialize inputs to validate node in binary search tree
        List<String> validateNodes = Arrays.asList("demo", "binary", "gamer", "how", "throne", "trex");

        // validate inputs from binary search tree
        CustomLogger.log("VALIDATE BST", () -> validate(validateNodes));

        // initialize inputs to delete node in binary search tree
        List<String> deleteNodes = Arrays.asList("throne", "trex", "search");

        // delete nodes in binary search tree
        CustomLogger.log("DELETE NODE IN BST", () -> delete(deleteNodes));

        // print search tree after deletions
        CustomLogger.log("PRINT BST AFTER DELETE", this::print);

        // print binary search tree from specific node
        CustomLogger.log("PRINT SPECIFIC NODE IN BST", () -> print("demo"));
    }
}
