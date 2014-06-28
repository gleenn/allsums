package com.gleenn;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AllSumsTest {

    private static final int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    public void sumFor_returnsSumBetweenIndices() {
        AllSums allSums = new AllSums(values);
        testSums(allSums);
    }

    @Test
    public void sumFor_returnsSumBetweenIndices_forQuickToo() {
        AllSums allSums = new QuickAllSums(values);
        testSums(allSums);
    }

    private void testSums(AllSums allSums) {
        assertThat(allSums.getSums()).isEqualTo(new int[]{1, 3, 6, 10, 15, 21, 28, 36});
    }
}
