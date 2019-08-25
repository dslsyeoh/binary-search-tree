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
        initialize();

        updateNode("tree", "whale");

        insertNode();

        validateNodes();

        insertNode("throne");

        validateNodes(Arrays.asList("demo", "binary", "gamer", "how", "throne", "trex"));

        deleteNodes();

        updateNode("this", "renew");

        printNode("demo");
    }

    void initialize()
    {
        initialize(Arrays.asList("this", "is", "demo", "binary", "search", "tree", "in", "string", "throne", "trex", "is"));
    }

    void initialize(List<String> bst)
    {
        CustomLogger.log(String.format("Construct %s into BST", bst.toString()), () -> constructBST(bst));
        print("after initialize");
    }

    void insertNode()
    {
        insertNode("zebra");
    }

    void insertNode(String value)
    {
        CustomLogger.log(String.format("insert [%s] into binary search tree", value), () -> insert(value));
        print(String.format("after insert [%s]", value));
    }

    private void updateNode(String oldValue, String newValue)
    {
        CustomLogger.log(String.format("update [%s] to [%s] in binary search tree", oldValue, newValue), () -> update(oldValue, newValue));
        print(String.format("after update [%s] to [%s]", oldValue, newValue));
    }

    private void deleteNode(String value)
    {
        CustomLogger.log(String.format("delete [%s] in binary search tree", value), () -> delete(value));
        print(String.format("after delete [%s]", value));
    }

    private void deleteNodes()
    {
        deleteNodes(Arrays.asList("search", "zebra"));
    }

    private void deleteNodes(List<String> deleteNodes)
    {
        CustomLogger.log(String.format("delete %s in binary search tree", deleteNodes.toString()), () -> delete(deleteNodes));
        print(String.format("after delete %s", deleteNodes.toString()));
    }

    private void validateNode(String value)
    {
        CustomLogger.log(String.format("validate [%s] in binary search tree", value), () -> validate(value));
    }

    private void validateNodes()
    {
        validate(Arrays.asList("demo", "binary", "gamer", "how", "throne", "trex"));
    }

    private void validateNodes(List<String> nodes)
    {
        CustomLogger.log(String.format("validate %s in binary search tree", nodes.toString()), () -> validate(nodes));
    }

    private void print(String description)
    {
        CustomLogger.log(String.format("Inorder traversal of binary search tree %s", description), this::printInorder);
        CustomLogger.log(String.format("Preorder traversal of binary search tree %s", description), this::printPreOrder);
        CustomLogger.log(String.format("Postorder traversal of binary search tree %s", description), this::printPostOrder);
    }

    private void printNode(String value)
    {
        CustomLogger.log("Inorder traversal of [demo] in binary search tree", () -> printInorder(value));
        CustomLogger.log("Preorder traversal of [demo] in binary search tree", () -> printPreOrder(value));
        CustomLogger.log("Postorder traversal of [demo] in binary search tree", () -> printPostOrder(value));
    }
}
