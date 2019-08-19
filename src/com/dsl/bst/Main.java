package com.dsl.bst;

import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();

        // construct binary tree search
        List<Integer> bts = Arrays.asList(10, 1, 12, 5, 2, 11, 50, 30, 60, 29, 50, 70, 62, 1, 8, 6, 9, 7, 9, 10);
        bst.constructBST(bts);

        // print binary tree after insertions
        bst.print();

        // insert node into bst
        bst.insert(72);

        // print binary tree after insertions
        bst.print();

        // init inputs for validate
        List<Integer> validateNodes = Arrays.asList(11, 60, 20, 21, 50, 30);

        // validate inputs from binary tree
        bst.validate(validateNodes);
        
        // delete inputs for binary tree
        List<Integer> deleteNodes = Arrays.asList(10, 60);

        // delete node from binary tree
        bst.delete(deleteNodes);

        // print binary tree after deletions
        bst.print();

        // print binary tree from specific node
        bst.print(12);
    }
}
