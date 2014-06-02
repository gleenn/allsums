package com.gleenn;

public class AllSums {
    private Operation<Integer> operation;
    protected int[] values;
    protected int[][] cache;
    protected Counter counter;

    public AllSums(int[] values) {
        this.values = values;
    }

    protected void initialize() {
        this.operation = new Add();
        this.counter = new Counter();
        this.cache = new int[values.length][values.length];
    }

    public int between(int i, int j) {
        if (cache == null) buildCache();
        return cache[i][j-1];
    }

    protected void buildCache() {
        initialize();
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i; j < values.length; j++) {
                for(int k=i; k<=j; k++) {
                    cache[i][j] = operation.execute(counter, cache[i][j], values[k]);
                }
            }
        }
    }

}
