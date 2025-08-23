package com.edaakyil.java.app;

import com.edaakyil.java.app.thread.RandomTextGeneratorThread;

public class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        System.out.printf("Thread name: %s%n", self.getName());

        for (var i = 0; i < 10; i++) {
            var thread = new RandomTextGeneratorThread("Generator-" + (i + 1), 10, 5, 15);

            thread.start();
        }

        System.out.println("main ends!...");
    }
}
