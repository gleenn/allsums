package com.gleenn;

public class AllSums {
    protected Operation<Integer> add;
    protected int[] values;
    protected int[] cache;

    public AllSums(int[] values) {
        this.values = new int[values.length];
        System.arraycopy(values, 0, this.values, 0, values.length);
        this.add = new Add(new Counter());
        this.cache = new int[values.length + 1];
        this.cache[0] = add.getIdentity();
        buildCache();
    }

    public int valueUpTo(int i) {
        return cache[i];
    }

    protected void buildCache() {
        for (int i = 1; i <= values.length; i++) {
            cache[i] = add.execute(cache[i - 1], values[i - 1]);
        }
    }
}
