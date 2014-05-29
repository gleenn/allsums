package com.gleenn;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AllSumsTest {
    @Test
    public void sumFor_returnsSumBetweenIndices() {
        AllSums allSums = new AllSums(1, 2, 3, 4);
        assertThat(allSums.between(0,3)).isEqualTo(10);
    }
}
