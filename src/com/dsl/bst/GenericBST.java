/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst;

import java.util.List;
import java.util.Objects;

abstract class GenericBST<T>
{
    private GenericNode<T> root;
    private final Evaluator<T> isEqual;
    private final Evaluator<T> moreThan;

    GenericBST(Evaluator<T> isEqual, Evaluator<T> moreThan)
    {
        this.isEqual = isEqual;
        this.moreThan = moreThan;
    }

    void constructBST(List<T> bst)
    {
        bst.forEach(this::insert);
    }

    void insert(T value)
    {
        root = insert(root, value);
    }

    private GenericNode<T> insert(GenericNode<T> root, T value)
    {
        if(Objects.isNull(root)) return new GenericNode<>(value);

        if(isEqual.eval(root.getValue(), value)) return root;
        if(moreThan.eval(root.getValue(), value)) root.setLeft(insert(root.getLeft(), value));
        else root.setRight(insert(root.getRight(), value));
        return root;
    }

    void delete(List<T> nodes)
    {
        nodes.forEach(this::delete);
    }

    private void delete(T value)
    {
        if(Objects.nonNull(root))
        {
            if(isEqual.eval(root.getValue(), value))
            {
                root = null;
                return;
            }
            GenericNode<T> parent = findRoot(root, value);
            if(Objects.nonNull(parent))
            {
                if(moreThan.eval(parent.getValue(), value)) parent.setLeft(null);
                else parent.setRight(null);
            }
        }
    }

    private GenericNode<T> findRoot(GenericNode<T> root, T value)
    {
        GenericNode<T> leaf = moreThan.eval(root.getValue(), value) ? root.getLeft() : root.getRight() ;
        if(Objects.nonNull(leaf))
        {
            if(isEqual.eval(leaf.getValue(), value)) return root;
            return findRoot(leaf, value);
        }
        return null;
    }

    private GenericNode<T> findLeaf(GenericNode<T> root, T value)
    {
        if(Objects.nonNull(root))
        {
            GenericNode<T> leaf = moreThan.eval(root.getValue(), value) ? root.getLeft() : root.getRight() ;
            if(Objects.nonNull(leaf))
            {
                if(isEqual.eval(leaf.getValue(), value)) return leaf;
                return findLeaf(leaf, value);
            }
        }
        return null;
    }

    void print()
    {
        printBST("root");
    }

    void print(T value)
    {
        printBST("root", findLeaf(root, value));
    }

    private void printBST(String text)
    {
        printBST(text, root);
    }

    private void printBST(String text, GenericNode<T> root)
    {
        if(Objects.nonNull(root))
        {
            System.out.println(String.format("%s=%s", text, root.getValue()));
            printBST(text.concat(" left"), root.getLeft());
            printBST(text.concat(" right"), root.getRight());
        }
    }

    void validate(List<T> validateNode)
    {
        System.out.println("================================= BEGIN VALIDATE BINARY SEARCH TREE =================================");
        validateNode.forEach(node -> {
            if(node instanceof Integer)
            {
                System.out.println(String.format("Node value %d in binary search tree? %s", (Integer)node, hasNode(node) ? "Yes" : "No"));
            }
            else if(node instanceof String)
            {
                System.out.println(String.format("Node in binary search tree has %s? %s", String.valueOf(node), hasNode(node) ? "Yes" : "No"));
            }
        });
        System.out.println("================================== END VALIDATE BINARY SEARCH TREE ==================================");

    }

    private boolean hasNode(T value)
    {
        return Objects.nonNull(root) && validate(root, value);
    }

    private boolean validate(GenericNode<T> root, T value)
    {
        if(Objects.isNull(root)) return false;
        if(root.getValue() == value) return true;
        else return validate(root.getLeft(), value) || validate(root.getRight(), value);
    }

    public abstract void demo();
}
