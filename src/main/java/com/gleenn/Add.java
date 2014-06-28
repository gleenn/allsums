package com.gleenn;

public class Add extends Operation<Integer>
{
    public Add(Counter counter) {
        super(counter);
    }

    @Override
    public Integer execute(Integer a, Integer b) {
        getCounter().increment();
        return a + b;
    }

    @Override
    public Integer getIdentity() {
        return 0;
    }


}
