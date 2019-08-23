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
        CustomLogger.log(String.format("Construct %s into BST", bst.toString()), () -> constructBST(bst));

        // print initial binary search tree
        CustomLogger.log("Inorder traversal of binary tree", this::printInorder);
        CustomLogger.log("Preorder traversal of binary tree after insert", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary tree after insert", this::printPostOrder);

        // insert node into binary search tree
        CustomLogger.log("insert zebra into binary search tree", () -> insert("zebra"));

        // print search tree after insertions
        CustomLogger.log("Inorder traversal of binary tree", this::printInorder);
        CustomLogger.log("Preorder traversal of binary tree after insert", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary tree after insert", this::printPostOrder);

        // initialize inputs to validate node in binary search tree
        List<String> validateNodes = Arrays.asList("demo", "binary", "gamer", "how", "throne", "trex");

        // validate inputs from binary search tree
        CustomLogger.log("validate nodes in binary search tree", () -> validate(validateNodes));

        // initialize inputs to delete node in binary search tree
        List<String> deleteNodes = Arrays.asList("throne", "trex", "search");

        // delete nodes in binary search tree
        CustomLogger.log("delete nodes in binary search tree", () -> delete(deleteNodes));

        // print search tree after deletions
        CustomLogger.log("Inorder traversal of binary tree after delete", this::printInorder);

        // print binary search tree from specific node
        CustomLogger.log("Inorder traversal of binary tree", () -> printInorder("demo"));
    }
}
