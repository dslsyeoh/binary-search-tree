/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst;

import java.util.ArrayList;
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


    void update(T oldValue, T newValue)
    {
//        GenericNode<T> parent = findRoot(root, oldValue);
//        GenericNode<T> leaf = findLeaf(root, oldValue);
//        if(Objects.nonNull(parent) && Objects.nonNull(leaf)) constructBST(renewRoot(oldValue, newValue, parent, leaf));
    }

    private List<T> renewRoot(T oldValue, T newValue, GenericNode<T> parent, GenericNode<T> leaf)
    {
//        List<T> newBST = new ArrayList<>();
//        newBST.add(newValue);
//        regenerate(newBST, leaf, oldValue);
//        System.out.println(newBST);
//        resetChildren(parent);
//        return newBST;
        return new ArrayList<>();
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
        if(moreThan.eval(root.getValue(), value)) return validate(root.getLeft(), value);
        return validate(root.getRight(), value);
    }

    void printInorder()
    {
        System.out.print("Inorder traversal: ");
        inOrder(root);
        System.out.println();
    }

    void printInorder(T value)
    {
        System.out.print("Inorder traversal: ");
        inOrder(findLeaf(root, value));
        System.out.println();
    }

    private void inOrder(GenericNode<T> root)
    {
        if(Objects.nonNull(root))
        {
            inOrder(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrder(root.getRight());
        }
    }

    void printPreOrder()
    {
        System.out.print("Preorder traversal: ");
        preOrder(root);
        System.out.println();
    }

    void printPreOrder(T value)
    {
        System.out.print("Preorder traversal: ");
        preOrder(findLeaf(root, value));
        System.out.println();
    }

    private void preOrder(GenericNode<T> root)
    {
        if(Objects.nonNull(root))
        {
            System.out.print(root.getValue() + " ");
            inOrder(root.getLeft());
            inOrder(root.getRight());
        }
    }

    void printPostOrder()
    {
        System.out.print("Postorder traversal: ");
        postOrder(root);
        System.out.println();
    }

    void printPostOrder(T value)
    {
        System.out.print("Postorder traversal: ");
        postOrder(findLeaf(root, value));
        System.out.println();
    }


    private void postOrder(GenericNode<T> root)
    {
        if(Objects.nonNull(root))
        {
            inOrder(root.getLeft());
            inOrder(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }


    private void resetChildren(GenericNode<T> parent)
    {
//        parent.setLeft(null);
//        parent.setRight(null);
    }

    private List<T> regenerate(List<T> newBST, GenericNode<T> root, T oldValue)
    {
//        if(newBST.isEmpty()) new ArrayList<>();
//
//        if(Objects.nonNull(root))
//        {
//            if(!isEqual.eval(root.getValue(), oldValue)) newBST.add(root.getValue());
//            regenerate(newBST, root.getLeft(), root.getValue());
//            regenerate(newBST, root.getRight(), root.getValue());
//        }
//        return newBST;
        return new ArrayList<>();
    }

    public abstract void demo();
}
