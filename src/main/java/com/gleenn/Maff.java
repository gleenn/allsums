package com.gleenn;

import static java.lang.Integer.numberOfLeadingZeros;

public class Maff {
    public static int logB2(int value) {
        return Integer.SIZE - numberOfLeadingZeros(value) - 1;
    }

    public static int twoPow(int d) {
        return 1 << d;
    }
}
