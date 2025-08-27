package com.edaakyil.java.app;

import com.karandev.util.console.Console;

public class Application {
    public static void run(String[] args)
    {
        var incrementer = new IntIncrementer(Console.readInt("Input count: "));

        incrementer.run(Console.readInt("Input number of threads: "));

        System.out.printf("Value1: %d%n", incrementer.getValue1());
        System.out.printf("Value2: %d%n", incrementer.getValue2());
    }
}
