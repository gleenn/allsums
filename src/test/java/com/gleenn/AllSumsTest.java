package com.gleenn;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AllSumsTest {

    private int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

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
        assertThat(allSums.between(0,1)).isEqualTo(1);
        assertThat(allSums.between(0,2)).isEqualTo(3);
        assertThat(allSums.between(0,3)).isEqualTo(6);
        assertThat(allSums.between(0,4)).isEqualTo(10);
        assertThat(allSums.between(0, 8)).isEqualTo(36);
    }
}
