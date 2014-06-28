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

    @Test
    public void twoPow() {
        assertThat(QuickAllSums.twoPow(0)).isEqualTo(1);
        assertThat(QuickAllSums.twoPow(1)).isEqualTo(2);
        assertThat(QuickAllSums.twoPow(2)).isEqualTo(4);
        assertThat(QuickAllSums.twoPow(3)).isEqualTo(8);
    }

    @Test
    public void logB2() {
        assertThat(QuickAllSums.logB2(1)).isEqualTo(0);
        assertThat(QuickAllSums.logB2(2)).isEqualTo(1);
        assertThat(QuickAllSums.logB2(4)).isEqualTo(2);
        assertThat(QuickAllSums.logB2(8)).isEqualTo(3);
        assertThat(QuickAllSums.logB2(16)).isEqualTo(4);
        assertThat(QuickAllSums.logB2(17)).isEqualTo(4);

    }
}
