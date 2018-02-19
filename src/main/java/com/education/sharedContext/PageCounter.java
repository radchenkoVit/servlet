package com.education.sharedContext;

import java.util.concurrent.atomic.AtomicInteger;

public class PageCounter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}
