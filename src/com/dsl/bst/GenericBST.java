package com.dsl.bst;

import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

abstract class GenericBST<T>
{
    private Node<T> root;
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

    private Node<T> insert(Node<T> parent, T value)
    {
        if(Objects.isNull(parent)) return new Node<>(value);

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
        Node<T> parent = findParent(root, value);
        if(Objects.nonNull(parent))
        {
            if(moreThan.eval(parent.getValue(), value)) parent.setRight(null);
            else parent.setLeft(null);
        }
    }

    private Node<T> findParent(Node<T> root, T value)
    {
        if(Objects.nonNull(root))
        {
            Node<T> child = lessThan.eval(root.getValue(), value) ? root.getRight() : root.getLeft() ;
            if(Objects.nonNull(child))
            {
                if(isEqual.eval(child.getValue(), value)) return root;
                return findParent(child, value);
            }
        }
        return null;
    }

    private Node<T> find(Node<T> root, T value)
    {
        if(Objects.nonNull(root))
        {
            Node<T> child = lessThan.eval(root.getValue(), value) ? root.getRight() : root.getLeft() ;
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
        out.println("================================= BEGIN PRINT BINARY SEARCH TREE =================================");
        printBST("root", find(root, value));
        out.println("================================== END PRINT BINARY SEARCH TREE ==================================");

    }

    private void printBST(String text)
    {
        out.println("================================= BEGIN PRINT BINARY SEARCH TREE =================================");
        printBST(text, root);
        out.println("================================== END PRINT BINARY SEARCH TREE ==================================");
    }

    private void printBST(String text, Node<T> root)
    {
        if(Objects.nonNull(root))
        {
            out.println(String.format("%s=%s", text, root.getValue()));
            printBST(text.concat(" left"), root.getLeft());
            printBST(text.concat(" right"), root.getRight());
        }
    }

    void validate(List<T> validateNode)
    {
        out.println("================================= BEGIN VALIDATE BINARY SEARCH TREE =================================");
        validateNode.forEach(node -> {
            if(node instanceof Integer)
            {
                out.println(String.format("Node value %d in binary search tree? %s", (Integer)node, hasNode(node) ? "Yes" : "No"));
            }
            else if(node instanceof String)
            {
                out.println(String.format("Node in binary search tree has %s? %s", String.valueOf(node), hasNode(node) ? "Yes" : "No"));
            }
        });
        out.println("================================== END VALIDATE BINARY SEARCH TREE ==================================");

    }

    private boolean hasNode(T value)
    {
        return Objects.nonNull(root) && validate(root, value);
    }

    private boolean validate(Node<T> root, T value)
    {
        if(Objects.isNull(root)) return false;
        if(root.getValue() == value) return true;
        else return validate(root.getLeft(), value) || validate(root.getRight(), value);
    }

    public abstract void demo();
}
