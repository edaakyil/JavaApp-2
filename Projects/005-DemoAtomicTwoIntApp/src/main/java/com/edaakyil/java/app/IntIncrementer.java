package com.edaakyil.java.app;

public class IntIncrementer {
    private int m_value1;
    private long m_value2;
    private final int m_count;

    private void incrementerCallback()
    {
        for (var i = 0; i < m_count; ++i) {
            // Bir kritik bölgeye yanlızca tek bir akışın girmesini sağlayan syncronizasyon nesnesine mutex denir
            // Java'da doğrudan mutex sınıfı yok. Fakat Java dilinin doğasında özel bir deyim var: synchronized deyimi
            // synchronized deyimi bir Object ile çalışıyor
            synchronized (this) {
                ++m_value1;
                m_value2 += m_value1;
            }
        }
    }

    public IntIncrementer(int count)
    {
        m_count = count;
    }

    public int getValue1()
    {
        return m_value1;
    }

    public long getValue2()
    {
        return m_value2;
    }

    public void run(int nThreads)
    {
        Thread[] threads = new Thread[nThreads];

        for (var i = 0; i < nThreads; ++i) {
            threads[i] = new Thread(this::incrementerCallback, "Thread"); // threads[i] = new Thread(() -> incrementerCallback(), "Thread");
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
