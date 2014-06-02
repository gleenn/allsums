package com.gleenn;

public class Add implements Operation<Integer>
{
    @Override
    public Integer execute(Counter counter, Integer a, Integer b) {
        counter.increment();
        return a + b;
    }
}
