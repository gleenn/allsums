package com.gleenn;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class QuickAllSumsTest {
    private static final int[] values = new int[]{3, 1, 7, 0, 4, 1, 6, 3};

    @Test
    public void sweepUp_returnsArrayWithPartialSumsFilteredUp() {
        int[] expected = {3, 4, 7, 11, 4, 5, 6, 25};
        assertThat(new QuickAllSums(values).sweepUp()).isEqualTo(expected);
    }

    @Test
    public void sweepDown_returnsArrayWithAllSums() {
        QuickAllSums quickAllSums = new QuickAllSums(values);
        quickAllSums.sweepUp();
        int[] expected = {0, 3, 4, 11, 11, 15, 16, 22};
        assertThat(quickAllSums.sweepDown()).isEqualTo(expected);
    }
}
