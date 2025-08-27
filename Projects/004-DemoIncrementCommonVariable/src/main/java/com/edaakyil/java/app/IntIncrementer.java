package com.edaakyil.java.app;

import java.util.concurrent.atomic.AtomicInteger;

public class IntIncrementer {
    // AtomicInteger sınıfının görevi atomik işlemler yapmak üzere int türden bir değişkeni sarmalamaktır (yani sarlamala görevi atomik işlemler yapmaktır)
    private AtomicInteger m_value;
    private final int m_count;

    private void runCallback(int idx)
    {
        System.out.printf("%s-%d created%n", Thread.currentThread().getName(), idx);

        for (var i = 0; i < m_count; ++i)
            m_value.getAndIncrement();
    }

    public IntIncrementer(int count)
    {
        m_count = count;
        // AtomicInteger sınıfının default ctor'u içeride sarmaladığı sayıyı 0 olarak set eder.
        m_value = new AtomicInteger(); // 0 ile başlatılan bir int türden değişkeni sarmalar
    }

    public int getValue()
    {
        return m_value.get();
    }

    public void run(int nThreads)
    {
        Thread[] threads = new Thread[nThreads];

        for (var i = 0; i < nThreads; ++i) {
            var idx  = i;

            threads[i] = new Thread(() -> runCallback(idx), "Thread");
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
