package com.edaakyil.java.app;

import com.karandev.util.console.Console;

public class Application {
    public static void run(String[] args)
    {
        var incrementer = new IntIncrementer(Console.readInt("Input count: "));

        incrementer.run(Console.readInt("Input number of threads: "));

        // join ile thread'lerin akışını bekletmemizin nedeni:
        // incrementer.run(2) işlemi bittikten sonra yani threadler işlenmlerini bitirdikten sonra
        // value'nun değerini yazdırmak
        System.out.printf("Value: %d%n", incrementer.getValue());
    }
}
