package com.gleenn;

public abstract class Operation<T> {
    private final Counter counter;

    public Operation(Counter counter) {
        this.counter = counter;
    }

    public abstract T execute(T first, T second);

    public abstract T getIdentity();

    public Counter getCounter() {
        return counter;
    }
}
