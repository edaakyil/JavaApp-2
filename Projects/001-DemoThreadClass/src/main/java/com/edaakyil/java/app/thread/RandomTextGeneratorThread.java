package com.edaakyil.java.app.thread;

import org.csystem.util.concurrent.ThreadUtil;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class RandomTextGeneratorThread extends Thread {
    private final Random m_random = new Random();
    private final int m_min;
    private final int m_bound;
    private final int m_count;

    public RandomTextGeneratorThread(String name, int count, int min, int bound)
    {
        super(name);
        m_min = min;
        m_bound = bound;
        m_count = count;
    }

    @Override
    public void run()
    {
        for (var i = 0; i < m_count; ++i) {
            var text = StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_min, m_bound));

            System.out.printf("%s -> %s%n", getName(), text);

            ThreadUtil.sleep(m_random.nextLong(300, 501));
        }

        System.out.printf("%s thread ends!...%n", getName());
    }
}
