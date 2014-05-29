package com.gleenn;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AllSumsTest {
    @Test
    public void sumFor_returnsSumBetweenIndices() {
        AllSums allSums = new AllSums(1, 2, 3, 4);
        assertThat(allSums.between(0,1)).isEqualTo(1);
        assertThat(allSums.between(0,2)).isEqualTo(3);
        assertThat(allSums.between(0,3)).isEqualTo(6);
        assertThat(allSums.between(0,4)).isEqualTo(10);
    }
}
