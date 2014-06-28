package com.gleenn;

import static com.gleenn.Maff.logB2;
import static com.gleenn.Maff.twoPow;

public class QuickAllSums extends AllSums {
    private static final int NUM_PROCESSORS = 4;
    private final int n;
    private final int steps;
    private Operation<Integer> add;
    private int lastValue;

    public QuickAllSums(int[] values) {
        super(values);
        n = values.length;
        steps = logB2(n) - 1;
    }

    @Override
    public int[] getSums(Counter counter) {
        this.add = new Add(counter);
        sweepUp();
        sweepDown();
        int[] result = new int[n];

        return values;
    }

    public int[] sweepUp() {
        for(int d = 0; d <= steps; d++) {
            //parallel
            for(int i = 0; i <= n - 1; i += twoPow(d + 1)) {
                final int indexModified = i + twoPow(d + 1) - 1;
                final int indexModifiedSibling = i + twoPow(d) - 1;
                values[indexModified] = add.execute(values[indexModified], values[indexModifiedSibling]);
            }
        }
        lastValue = values[n - 1];
        return values;
    }

    public int[] sweepDown() {
        values[n - 1] = add.getIdentity();
        for(int d = steps; d >= 0; d--) {
            //parallel
            for(int i = 0; i <= n - 1; i += twoPow(d + 1)) {
                int temp = values[i + twoPow(d) - 1];
                values[i + twoPow(d) - 1] = values[i + twoPow(d + 1) - 1];
                values[i + twoPow(d + 1) - 1] = temp + values[i + twoPow(d + 1) - 1];
            }
        }
        for(int i = 0; i<n-1; i++) values[i] = values[i+1];
        values[n - 1] = lastValue;
        return values;
    }
}
