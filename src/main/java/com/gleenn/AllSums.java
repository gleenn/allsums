package com.gleenn;

public class AllSums {
    protected Operation<Integer> add;
    protected int[] values;
    protected int[] cache;

    public AllSums(int[] values) {
        this.values = values.clone();
        this.add = new Add(new Counter());
    }

    public int[] getSums() {
        for (int i = 1; i < values.length; i++) {
            values[i] = add.execute(values[i], values[i - 1]);
        }
        return values;
    }
}
