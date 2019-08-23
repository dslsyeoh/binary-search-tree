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

        // update node in binary search tree
        CustomLogger.log("update [tree] to [whale] in binary search tree", () -> update("tree", "whale"));

        // print binary search tree after update
        CustomLogger.log("Inorder traversal of binary search tree after update", this::printInorder);
        CustomLogger.log("Preorder traversal of binary search tree after update", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary search tree after update", this::printPostOrder);

        // insert node into binary search tree
        CustomLogger.log("insert [zebra] into binary search tree", () -> insert("zebra"));

        // print search tree after insertions
        CustomLogger.log("Inorder traversal of binary tree after insert [zebra]", this::printInorder);
        CustomLogger.log("Preorder traversal of binary tree after insert [zebra]", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary tree after insert [zebra]", this::printPostOrder);

        // initialize inputs to validate node in binary search tree
        List<String> validateNodes = Arrays.asList("demo", "binary", "gamer", "how", "throne", "trex");

        // validate inputs from binary search tree
        CustomLogger.log(String.format("validate %s in binary search tree", validateNodes.toString()), () -> validate(validateNodes));

        CustomLogger.log("insert [throne] into binary search tree", () -> insert("throne"));

        // initialize inputs to validate node in binary search tree
        List<String> validateNodes2 = Arrays.asList("demo", "binary", "gamer", "how", "throne", "trex");

        // validate inputs from binary search tree
        CustomLogger.log(String.format("validate %s in binary search tree", validateNodes.toString()), () -> validate(validateNodes2));

        // initialize inputs to delete node in binary search tree
        List<String> deleteNodes = Arrays.asList("search", "zebra");

        // delete nodes in binary search tree
        CustomLogger.log(String.format("delete %s in binary search tree", deleteNodes.toString()), () -> delete(deleteNodes));

        // print binary search tree after delete
        CustomLogger.log("Inorder traversal of binary search tree after delete [search, zebra]", this::printInorder);
        CustomLogger.log("Preorder traversal of binary search tree after delete [search, zebra]", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary search tree after delete [search, zebra]", this::printPostOrder);

        // print binary search tree from specific node
        CustomLogger.log("Inorder traversal of [demo] in binary search tree", () -> printInorder("demo"));
        CustomLogger.log("Preorder traversal of [demo] in binary search tree", () -> printPreOrder("demo"));
        CustomLogger.log("Postorder traversal of [demo] in binary search tree", () -> printPostOrder("demo"));
    }
}
