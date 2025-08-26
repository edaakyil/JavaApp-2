package com.edaakyil.java.app;

import com.edaakyil.java.app.thread.RandomTextGenerator;
import com.karandev.util.console.Console;

public class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        var nThreads = Console.readInt("Input number of threads: ");
        var count = Console.readInt("Input count: ");

        System.out.printf("Thread name: %s%n", self.getName());

        for (var i = 0; i < nThreads; i++) {
            var generator = new RandomTextGenerator(count, 5, 15);

            var thread = new Thread(generator, "Generator-" + (i + 1)); // RandomTextGenerator türünden nesne Thread ile sarmalandı ve artık şimdi Thread sınıfı oldu

            thread.start();
        }

        System.out.println("main ends!...");
    }
}
