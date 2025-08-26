package com.edaakyil.java.app;

import com.karandev.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        var nThreads = Console.readInt("Input number of threads: ");
        var count = Console.readInt("Input count: ");

        System.out.printf("Thread name: %s%n", self.getName());

        Runnable[] runnables = new Runnable[nThreads];

        for (var i = 0; i < nThreads; i++) {
            // Her thread için ayrı bir Random nesnesi yaratılacak
            // Yani herbir thread'in kullandığı Random nesnesi dışarıdan farklı olarak alınıyor
            var random = new Random();

            runnables[i] = () -> randomTextGeneratorCallback(random, count, 5, 15);

            var thread = new Thread(runnables[i], "Generator-" + (i + 1));

            thread.start();
        }

        for (var runnable : runnables) {
            System.err.println(runnable.getClass().getName()); // Nesnenin türünü yani referansın dinamik türünü yazdırır
            System.err.println(runnable);  // Nesnenin adresini yazdırır
        }

        System.out.println("main ends!...");
    }

    private static void randomTextGeneratorCallback(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        var name = Thread.currentThread().getName();

        for (var i = 0; i < count; ++i) {
            var text = StringUtil.getRandomTextEN(randomGenerator, randomGenerator.nextInt(min, bound));

            System.out.printf("%s -> %s%n", name, text);
        }
    }
}
