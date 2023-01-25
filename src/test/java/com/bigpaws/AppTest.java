package com.bigpaws;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void test() {
        ParentChildHisto pch = new ParentChildHisto();
        pch.probe("a").accept(123456789);
        pch.sampleNanos(666666666666L);
        Assert.assertEquals(
                "end-to-end: 50/90 99/99.9 99.99 - worst was 666,793,670 / 666,793,670  666,793,670 / 666,793,670  666,793,670 - 666,793,670\n" +
                "a: 50/90 99/99.9 99.99 - worst was 123,340 / 123,340  123,340 / 123,340  123,340 - 123,340\n", pch.output());
    }
}
