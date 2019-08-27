/*
 * Owned by Steven Yeoh
 * Copyright (c) 2019.
 */

package com.dsl.bst.utils;

@FunctionalInterface
public interface Evaluator<T>
{
    boolean eval(T source, T target);
}
