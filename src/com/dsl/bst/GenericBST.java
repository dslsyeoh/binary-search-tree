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

    void validate(List<T> validateNode)
    {
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

    void printInorder()
    {
        System.out.print("Inorder traversal: ");
        print(root);
        System.out.println();
    }

    void printInorder(T value)
    {
        System.out.print("Inorder traversal: ");
        print(findLeaf(root, value));
        System.out.println();
    }

    private void print(GenericNode<T> root)
    {
        if(Objects.nonNull(root))
        {
            print(root.getLeft());
            System.out.print(root.getValue() + " ");
            print(root.getRight());
        }
    }

    public abstract void demo();
}
