package com.edaakyil.java.app;

public class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        System.out.printf("Thread name: %s%n", self.getName());
    }
}
