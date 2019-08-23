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
        CustomLogger.log(String.format("Construct %s into BST", bst.toString()), () -> constructBST(bst));

//        // print initial binary search tree
        CustomLogger.log("Inorder traversal of binary tree", this::printInorder);
        CustomLogger.log("Preorder traversal of binary tree after insert", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary tree after insert", this::printPostOrder);

        // update node in binary search tree
        CustomLogger.log("update 70 to 72 in binary search tree", () -> update(70, 72));

        // print binary search tree after update
        CustomLogger.log("Inorder traversal of binary tree after update", this::printInorder);
        CustomLogger.log("Preorder traversal of binary tree after update", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary tree after update", this::printPostOrder);

        // insert node into binary search tree
        CustomLogger.log("insert 73 into binary search tree", () -> insert(73));

        // print binary search tree after insert
        CustomLogger.log("Inorder traversal of binary tree after insert", this::printInorder);
        CustomLogger.log("Preorder traversal of binary tree after insert", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary tree after insert", this::printPostOrder);

        // initialize inputs to validate node in binary search tree
        List<Integer> validateNodes = Arrays.asList(11, 60, 20, 21, 50, 82);

        // validate inputs from binary search tree
        CustomLogger.log(String.format("validate %s in binary search tree", validateNodes.toString()), () -> validate(validateNodes));

        // update node in binary search tree
        CustomLogger.log("update 72 to 82 in binary search tree", () -> update(72, 82));

        // initialize inputs to validate node in binary search tree
        List<Integer> validateNodes2 = Arrays.asList(11, 60, 20, 21, 72, 82);

        // validate inputs from binary search tree
        CustomLogger.log(String.format("validate %s in binary search tree", validateNodes.toString()), () -> validate(validateNodes2));

        // initialize inputs to delete node in binary search tree
        List<Integer> deleteNodes = Arrays.asList(11, 60);

        // delete nodes in binary search tree
        CustomLogger.log("delete nodes in binary search tree", () -> delete(deleteNodes));

        // print binary search tree after delete
        CustomLogger.log("Inorder traversal of binary tree after delete", this::printInorder);
        CustomLogger.log("Preorder traversal of binary tree after delete", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary tree after delete", this::printPostOrder);

        // print binary search tree from specific node
        CustomLogger.log("Inorder traversal of binary tree", () -> printInorder(12));
        CustomLogger.log("Preorder traversal of binary tree", () -> printPreOrder(12));
        CustomLogger.log("Postorder traversal of binary tree", () -> printPostOrder(12));
    }
}
