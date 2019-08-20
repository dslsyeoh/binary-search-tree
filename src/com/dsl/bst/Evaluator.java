package com.dsl.bst;

@FunctionalInterface
public interface Evaluator<T>
{
    boolean eval(T source, T target);
}
