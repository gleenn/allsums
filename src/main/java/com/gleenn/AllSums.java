package com.gleenn;

public class AllSums {
    private Operation<Integer> add;
    protected int[] values;
    protected int[] cache;
    protected Counter counter;

    public AllSums(int[] values) {
        this.values = values;
    }

    protected void initialize() {
        this.add = new Add();
        this.counter = new Counter();
        this.cache = new int[values.length + 1];
        this.cache[0] = add.getIdentity();
    }

    public int valueUpTo(int i) {
        if (cache == null) buildCache();
        return cache[i];
    }

    protected void buildCache() {
        initialize();
        for (int i = 1; i <= values.length; i++) {
            cache[i] = add.execute(counter, cache[i - 1], values[i - 1]);
        }
    }
}
