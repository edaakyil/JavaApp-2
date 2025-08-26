package com.edaakyil.java.app;

import com.karandev.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        var nThreads = Console.readInt("Input number of threads: ");
        var count = Console.readInt("Input count: ");

        System.out.printf("Thread name: %s%n", self.getName());

        for (var i = 0; i < nThreads; i++) {
            var thread = new Thread(() -> randomTextGeneratorCallback(count, 5, 15), "Generator-" + (i + 1));

            thread.start();
        }

        System.out.println("main ends!...");
    }

    private static void randomTextGeneratorCallback(int count, int min, int bound)
    {
        var random = new Random();
        var name = Thread.currentThread().getName();

        for (var i = 0; i < count; ++i) {
            var text = StringUtil.getRandomTextEN(random, random.nextInt(min, bound));

            System.out.printf("%s -> %s%n", name, text);
        }
    }
}
