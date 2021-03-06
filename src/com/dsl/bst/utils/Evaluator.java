/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.bst.utils;

@FunctionalInterface
public interface Evaluator<T>
{
    boolean eval(T source, T target);
}
