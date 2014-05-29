package com.gleenn;

public class AllSums {
    private int[] values;
    private int[][] cache;

    public AllSums(int... values) {
        this.values = values;
    }

    public int between(int i, int j) {
        if (cache == null) buildCache();
        return cache[i][j-1];
    }

    private void buildCache() {
        this.cache = new int[values.length][values.length];
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i; j < values.length; j++) {
                for(int k=i; k<=j; k++) {
                    cache[i][j] += values[k];
                }
            }
        }
    }


}
