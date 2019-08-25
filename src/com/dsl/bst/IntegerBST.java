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
        initialize();

        updateNode(70, 72);

        insertNode();

        printNode(50);

        validateNodes();

        updateNode(72, 82);

        validateNodes(Arrays.asList(11, 60, 20, 21, 72, 82));

        deleteNodes();

        updateNode(10, 100);
    }

    void initialize()
    {
        initialize(Arrays.asList(10, 1, 12, 5, 2, 11, 50, 30, 60, 29, 50, 70, 62, 1, 8, 6, 9, 7, 9, 10, 0));
    }

    void initialize(List<Integer> bst)
    {
        CustomLogger.log(String.format("Construct %s into BST", bst.toString()), () -> constructBST(bst));
        print("after initialize");
    }

    void insertNode()
    {
        insertNode(73);
    }

    void insertNode(int value)
    {
        CustomLogger.log(String.format("insert [%d] into binary search tree", value), () -> insert(value));
        print(String.format("after insert [%d]", value));
    }

    private void updateNode(int oldValue, int newValue)
    {
        CustomLogger.log(String.format("update [%d] to [%d] in binary search tree", oldValue, newValue), () -> update(oldValue, newValue));
        print(String.format("after update [%d] to [%d]", oldValue, newValue));
    }

    private void deleteNode(int value)
    {
        CustomLogger.log(String.format("delete [%d] in binary search tree", value), () -> delete(value));
        print(String.format("after delete [%d]", value));
    }

    private void deleteNodes()
    {
        deleteNodes(Arrays.asList(11, 60));
    }

    private void deleteNodes(List<Integer> deleteNodes)
    {
        CustomLogger.log(String.format("delete %s in binary search tree", deleteNodes.toString()), () -> delete(deleteNodes));
        print(String.format("after delete %s", deleteNodes.toString()));
    }

    private void validateNode(int value)
    {
        CustomLogger.log(String.format("validate [%d] in binary search tree", value), () -> validate(value));
    }

    private void validateNodes()
    {
        validate(Arrays.asList(11, 60, 20, 21, 50, 82));
    }

    private void validateNodes(List<Integer> nodes)
    {
        CustomLogger.log(String.format("validate %s in binary search tree", nodes.toString()), () -> validate(nodes));
    }

    private void print(String description)
    {
        CustomLogger.log(String.format("Inorder traversal of binary search tree %s", description), this::printInorder);
        CustomLogger.log(String.format("Preorder traversal of binary search tree %s", description), this::printPreOrder);
        CustomLogger.log(String.format("Postorder traversal of binary search tree %s", description), this::printPostOrder);
    }

    private void printNode(int value)
    {
        CustomLogger.log(String.format("Inorder traversal of [%d] in binary search tree", value), () -> printInorder(value));
        CustomLogger.log(String.format("Preorder traversal of [%d] in binary search tree", value), () -> printPreOrder(value));
        CustomLogger.log(String.format("Postorder traversal of [%d] in binary search tree", value), () -> printPostOrder(value));
    }
}
