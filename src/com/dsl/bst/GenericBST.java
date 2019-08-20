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
    private final Evaluator<T> lessThan;
    private final Evaluator<T> moreThan;

    GenericBST(Evaluator<T> isEqual, Evaluator<T> lessThan, Evaluator<T> moreThan)
    {
        this.isEqual = isEqual;
        this.lessThan = lessThan;
        this.moreThan = moreThan;
    }

    void constructBST(List<T> bt)
    {
        bt.forEach(this::insert);
    }

    void insert(T value)
    {
        root = insert(root, value);
    }

    private GenericNode<T> insert(GenericNode<T> parent, T value)
    {
        if(Objects.isNull(parent)) return new GenericNode<>(value);

        if(isEqual.eval(parent.getValue(), value)) return parent;
        if(moreThan.eval(parent.getValue(), value)) parent.setLeft(insert(parent.getLeft(), value));
        else if(lessThan.eval(parent.getValue(), value)) parent.setRight(insert(parent.getRight(), value));
        return parent;
    }

    void delete(List<T> nodes)
    {
        nodes.forEach(this::delete);
    }

    private void delete(T value)
    {
        GenericNode<T> parent = findParent(root, value);
        if(Objects.nonNull(parent))
        {
            if(moreThan.eval(parent.getValue(), value)) parent.setRight(null);
            else parent.setLeft(null);
        }
    }

    private GenericNode<T> findParent(GenericNode<T> root, T value)
    {
        if(Objects.nonNull(root))
        {
            GenericNode<T> child = lessThan.eval(root.getValue(), value) ? root.getRight() : root.getLeft() ;
            if(Objects.nonNull(child))
            {
                if(isEqual.eval(child.getValue(), value)) return root;
                return findParent(child, value);
            }
        }
        return null;
    }

    private GenericNode<T> find(GenericNode<T> root, T value)
    {
        if(Objects.nonNull(root))
        {
            GenericNode<T> child = lessThan.eval(root.getValue(), value) ? root.getRight() : root.getLeft() ;
            if(Objects.nonNull(child))
            {
                if(isEqual.eval(child.getValue(), value)) return child;
                return find(child, value);
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
        System.out.println("================================= BEGIN PRINT BINARY SEARCH TREE =================================");
        printBST("root", find(root, value));
        System.out.println("================================== END PRINT BINARY SEARCH TREE ==================================");

    }

    private void printBST(String text)
    {
        System.out.println("================================= BEGIN PRINT BINARY SEARCH TREE =================================");
        printBST(text, root);
        System.out.println("================================== END PRINT BINARY SEARCH TREE ==================================");
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
