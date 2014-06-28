package com.gleenn;

import static java.lang.Integer.numberOfLeadingZeros;

public class QuickAllSums extends AllSums {

    private static final int NUM_PROCESSORS = 4;
    private final int n;
    private final int steps;

    public QuickAllSums(int[] values) {
        super(values);
        n = values.length;
        steps = logB2(n) - 1;
    }

    public static int logB2(int value) {
        return Integer.SIZE - numberOfLeadingZeros(value) - 1;
    }

    public static int twoPow(int d) {
        return 1 << d;
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
//          a[n − 1] ← 0 % Set the identity
//          for d from (lg n) − 1 downto 0
//              in parallel for i from 0 to n − 1 by 2^d+1
//                  t ← a[i + 2d − 1]                     % Save in temporary
//                  a[i + 2d − 1] ← a[i + 2d+1 − 1]       % Set left child
//                  a[i + 2d+1 − 1] ← t + a[i + 2d+1 − 1] % Set right child

        values[n - 1] = add.getIdentity();
        for(int d = steps; d >= 0; d--) {
            //parallel
            for(int i = 0; i <= n - 1; i += twoPow(d+1)) {
                int temp = values[i + twoPow(d) - 1];
                values[i + twoPow(d) - 1] = values[i + twoPow(d+1) - 1];
                values[i + twoPow(d+1) - 1] = temp + values[i + twoPow(d+1) - 1];
            }
        }

        return values;
    }
}
