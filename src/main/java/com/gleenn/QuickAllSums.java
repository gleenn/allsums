package com.gleenn;

import static com.gleenn.Maff.logB2;
import static com.gleenn.Maff.twoPow;

public class QuickAllSums extends AllSums {

    private static final int NUM_PROCESSORS = 4;
    private final int n;
    private final int steps;

    public QuickAllSums(int[] values) {
        super(values);
        n = values.length;
        steps = logB2(n) - 1;
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

        return values;
    }
}
