/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.bst.core;

import java.util.Arrays;

public class TestBST extends GenericBST<Integer>
{
    public TestBST()
    {
        super(Integer::equals, (source, target) -> source > target);
    }

    public void initialize()
    {
        constructBST(Arrays.asList(10, 1, 2, 12, 15, 30));
    }

    public void delete()
    {
        delete(15);
    }

    public void print()
    {
        printInorder();
    }
}
