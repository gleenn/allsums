package com.gleenn;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MaffTest {
    @Test
    public void twoPow() {
        assertThat(Maff.twoPow(0)).isEqualTo(1);
        assertThat(Maff.twoPow(1)).isEqualTo(2);
        assertThat(Maff.twoPow(2)).isEqualTo(4);
        assertThat(Maff.twoPow(3)).isEqualTo(8);
    }

    @Test
    public void logB2() {
        assertThat(Maff.logB2(1)).isEqualTo(0);
        assertThat(Maff.logB2(2)).isEqualTo(1);
        assertThat(Maff.logB2(4)).isEqualTo(2);
        assertThat(Maff.logB2(8)).isEqualTo(3);
        assertThat(Maff.logB2(16)).isEqualTo(4);
        assertThat(Maff.logB2(17)).isEqualTo(4);

    }
}