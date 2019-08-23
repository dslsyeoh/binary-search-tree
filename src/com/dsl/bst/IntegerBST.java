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
        CustomLogger.log("Inorder traversal of binary search tree", this::printInorder);
        CustomLogger.log("Preorder traversal of binary search tree", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary search tree", this::printPostOrder);

        // update node in binary search tree
        CustomLogger.log("update [70] to [72] in binary search tree", () -> update(70, 72));

        // print binary search tree after update
        CustomLogger.log("Inorder traversal of binary search tree after update", this::printInorder);
        CustomLogger.log("Preorder traversal of binary search tree after update", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary search tree after update", this::printPostOrder);

        // insert node into binary search tree
        CustomLogger.log("insert [73] into binary search tree", () -> insert(73));

        // print binary search tree after insert
        CustomLogger.log("Inorder traversal of binary search tree after insert [73]", this::printInorder);
        CustomLogger.log("Preorder traversal of binary search tree after insert [73]", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary search tree after insert [73]", this::printPostOrder);

        // initialize inputs to validate node in binary search tree
        List<Integer> validateNodes = Arrays.asList(11, 60, 20, 21, 50, 82);

        // validate inputs from binary search tree
        CustomLogger.log(String.format("validate %s in binary search tree", validateNodes.toString()), () -> validate(validateNodes));

        // update node in binary search tree
        CustomLogger.log("update [72] to [82] in binary search tree", () -> update(72, 82));

        // initialize inputs to validate node in binary search tree
        List<Integer> validateNodes2 = Arrays.asList(11, 60, 20, 21, 72, 82);

        // validate inputs from binary search tree
        CustomLogger.log(String.format("validate %s in binary search tree", validateNodes.toString()), () -> validate(validateNodes2));

        // initialize inputs to delete node in binary search tree
        List<Integer> deleteNodes = Arrays.asList(11, 60);

        // delete nodes in binary search tree
        CustomLogger.log(String.format("delete %s in binary search tree", deleteNodes.toString()), () -> delete(deleteNodes));

        // print binary search tree after delete
        CustomLogger.log("Inorder traversal of binary search tree after delete [11, 60]", this::printInorder);
        CustomLogger.log("Preorder traversal of binary search tree after delete [11, 60]", this::printPreOrder);
        CustomLogger.log("Postorder traversal of binary search tree after delete [11, 60]", this::printPostOrder);

        // print binary search tree from specific node
        CustomLogger.log("Inorder traversal of [12] in binary search tree", () -> printInorder(12));
        CustomLogger.log("Preorder traversal of [12] in binary search tree", () -> printPreOrder(12));
        CustomLogger.log("Postorder traversal of [12] in binary search tree", () -> printPostOrder(12));
    }
}
