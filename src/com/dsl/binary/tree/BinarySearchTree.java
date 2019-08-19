package com.dsl.binary.tree;

import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

class BinarySearchTree
{
    private Node root;
    private Evaluate isEqual = (source, target) -> source == target;
    private Evaluate moreThan = (source, target) -> target > source;

    void constructBST(List<Integer> bt)
    {
        bt.forEach(this::insert);
    }

    public void insert(int value)
    {
        root = insert(root, value);
    }

    private Node insert(Node parent, int value)
    {
        if(Objects.isNull(parent)) return new Node(value);

        if(parent.getValue() > value) parent.setLeft(insert(parent.getLeft(), value));
        else if(parent.getValue() <= value) parent.setRight(insert(parent.getRight(), value));
        return parent;
    }

    void delete(List<Integer> deleteNodes)
    {
        deleteNodes.forEach(this::delete);
    }

    private void delete(int value)
    {
        Node parent = findParent(root, value);
        if(Objects.nonNull(parent))
        {
            if(moreThan.eval(parent.getValue(), value)) parent.setRight(null);
            else parent.setLeft(null);
        }
    }

    private Node findParent(Node root, int value)
    {
        if(Objects.nonNull(root))
        {
            Node child = value >= root.getValue() ? root.getRight() : root.getLeft();
            if(Objects.nonNull(child))
            {
                if(isEqual.eval(child.getValue(), value)) return root;
                return findParent(child, value);
            }
        }
        return null;
    }

    private Node find(Node root, int value)
    {
        if(Objects.nonNull(root))
        {
            Node child = value >= root.getValue() ? root.getRight() : root.getLeft();
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
        print("root");
    }

    void print(int value)
    {
        out.println("=========== BEGIN PRINT BINARY TREE ===========");
        print("root", find(root, value));
        out.println("============ END PRINT BINARY TREE ============");

    }

    private void print(String text)
    {
        out.println("=========== BEGIN PRINT BINARY TREE ===========");
        print(text, root);
        out.println("============ END PRINT BINARY TREE ============");
    }

    private void print(String text, Node root)
    {
        if(Objects.nonNull(root))
        {
            out.println(String.format("%s=%s", text, root.getValue()));
            print(text.concat(" left"), root.getLeft());
            print(text.concat(" right"), root.getRight());
        }
    }

    void validate(List<Integer> validateNodes)
    {
        validateNodes.forEach(value -> out.println(String.format("Node in binary tree has %d? %s", value, hasNode(value) ? "Yes" : "No")));
    }

    private boolean hasNode(int value)
    {
        return Objects.nonNull(root) && validate(root, value);
    }

    private boolean validate(Node root, int value)
    {
        if(Objects.isNull(root)) return false;
        if(root.getValue() == value) return true;
        else return validate(root.getLeft(), value) || validate(root.getRight(), value);
    }

    @FunctionalInterface
    public interface Evaluate
    {
        boolean eval(int source, int target);
    }

}
