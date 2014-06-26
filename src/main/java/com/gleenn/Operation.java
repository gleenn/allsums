package com.gleenn;

public interface Operation<T> {
    public T execute(Counter counter, T first, T second);

    public T getIdentity();
}
