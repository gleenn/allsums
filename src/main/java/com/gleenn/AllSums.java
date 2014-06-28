package com.gleenn;

public class AllSums {
    private Operation<Integer> add;
    protected int[] values;

    public AllSums(int[] values) {
        this.values = values.clone();
    }

    public int[] getSums(Counter counter) {
        this.add = new Add(counter);
        for (int i = 1; i < values.length; i++) {
            values[i] = add.execute(values[i], values[i - 1]);
        }
        return values;
    }
}
