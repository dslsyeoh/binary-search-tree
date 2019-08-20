package com.dsl.bst;


public class GenericNode<T>
{
    private T value;
    private GenericNode<T> left;
    private GenericNode<T> right;

    GenericNode(T value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    T getValue()
    {
        return value;
    }

    GenericNode<T> getLeft() {
        return left;
    }

    void setLeft(GenericNode<T> left)
    {
        this.left = left;
    }

    GenericNode<T> getRight()
    {
        return right;
    }

    void setRight(GenericNode<T> right) {
        this.right = right;
    }
}
