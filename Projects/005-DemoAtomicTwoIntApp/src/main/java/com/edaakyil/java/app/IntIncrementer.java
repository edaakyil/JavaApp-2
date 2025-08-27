package com.edaakyil.java.app;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class IntIncrementer {
    private final int m_count;
    private final AtomicInteger m_value1;
    private final AtomicLong m_value2;

    private void incrementerCallback(int idx)
    {
        for (var i = 0; i < m_count; ++i) {
            m_value1.getAndIncrement();
            m_value2.getAndAdd(m_value1.get());
        }
    }

    public IntIncrementer(int count)
    {
        m_count = count;
        m_value1 = new AtomicInteger();
        m_value2 = new AtomicLong();
    }

    public int getValue1()
    {
        return m_value1.get();
    }

    public long getValue2()
    {
        return m_value2.get();
    }

    public void run(int nThreads)
    {
        Thread[] threads = new Thread[nThreads];

        for (var i = 0; i < nThreads; ++i) {
            var idx  = i;

            threads[i] = new Thread(() -> incrementerCallback(idx), "Thread");
            threads[i].start();
        }

        // Bir thread'in sonlanmasını bekleyen kod (bekletme kodu):
        // Bu kod ile bir thread sonlanana kadar bekliyoruz
        for (var t : threads)
            try {
                t.join();
            } catch (InterruptedException ex) {

            }
    }
}
