package com.dsl.binary.tree;

public class Node implements Comparable<Integer>
{
    private int value;
    private Node left;
    private Node right;

    Node(int value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    int getValue()
    {
        return value;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Integer value)
    {
        return Integer.compare(this.getValue(), value);
    }
}
