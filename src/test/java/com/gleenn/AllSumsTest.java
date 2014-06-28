package com.gleenn;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AllSumsTest {

    private static final int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    public void getSums_returnsSumBetweenIndices() {
        AllSums allSums = new AllSums(values);
        Counter counter = new Counter();
        testSums(allSums, counter);
        assertThat(counter.getCount()).isEqualTo(values.length - 1);
    }

    @Test
    public void getSums_returnsSumBetweenIndices_forQuickToo() {
        AllSums allSums = new QuickAllSums(values);
        Counter counter = new Counter();
        testSums(allSums, counter);
        assertThat(counter.getCount()).isEqualTo(7);
    }

    private void testSums(AllSums allSums, Counter counter) {
        assertThat(allSums.getSums(counter)).isEqualTo(new int[]{1, 3, 6, 10, 15, 21, 28, 36});
    }
}
