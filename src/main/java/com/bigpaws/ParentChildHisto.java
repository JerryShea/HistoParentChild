package com.bigpaws;

import net.openhft.chronicle.core.util.Histogram;

import java.util.HashMap;
import java.util.Map;
import java.util.function.LongConsumer;

public class ParentChildHisto {
    private final Histogram parent;
    private final Map<String, Histogram> children;

    ParentChildHisto() {
        parent = new Histogram();
        children = new HashMap<>();
    }

    LongConsumer probe(String name) {
        final Histogram child = children.computeIfAbsent(name, s -> new Histogram());
        return child::sampleNanos;
    }

    void sampleNanos(long sampleNanos) {
        parent.sampleNanos(sampleNanos);
    }

    void output() {
        System.out.println("end-to-end", );
    }
}
