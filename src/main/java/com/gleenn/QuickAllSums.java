package com.gleenn;

public class QuickAllSums extends AllSums {
    public QuickAllSums(int[] values) {
        super(values);
    }

    @Override
    public void buildCache() {
        initialize();

        sweepDown();
        sweepUp();
    }

    public void sweepUp() {
//        in parallel for each processor i
//          sum[i] ← a[(n/p)i]
//          for j from 1 to n/p
//              sum[i] ← sum[i] + a[(n/p)i + j]
//          result ← +-reduce(sum)

    }

    public void sweepDown() {
//        procedure down-sweep(A)
//          a[n − 1] ← 0 % Set the identity
//          for d from (lg n) − 1 downto 0
//              in parallel for i from 0 to n − 1 by 2^d+1
//                  t ← a[i + 2d − 1]                     % Save in temporary
//                  a[i + 2d − 1] ← a[i + 2d+1 − 1]       % Set left child
//                  a[i + 2d+1 − 1] ← t + a[i + 2d+1 − 1] % Set right child

    }
}
