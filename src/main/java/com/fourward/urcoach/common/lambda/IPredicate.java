package com.fourward.urcoach.common.lambda;

@FunctionalInterface
public interface IPredicate {
    public abstract Boolean test(Object o);    
}