package com.edaakyil.java.app;

public class Application {
    public static void run(String[] args)
    {
        var incrementer = new IntIncrementer(1_000_000);

        incrementer.run(2);

        // join ile thread'lerin akışını bekletmemizin nedeni:
        // incrementer.run(2) işlemi bittikten sonra yani threadler işlenmlerini bitirdikten sonra
        // value'nun değerini yazdırmak
        System.out.printf("Value: %d%n", incrementer.getValue());
    }
}
