package com.edaakyil.java.app;

public class IntIncrementer {
    private int m_value; // value start with 0
    private final int m_count;

    private void runCallback(int idx)
    {
        System.out.printf("%s-%d created%n", Thread.currentThread().getName(), idx);

        for (var i = 0; i < m_count; ++i)
            ++m_value;
    }

    public IntIncrementer(int count)
    {
        m_count = count;
    }

    public int getValue()
    {
        return m_value;
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
