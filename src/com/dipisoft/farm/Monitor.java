package com.dipisoft.farm;

public class Monitor {

    // Attribs
    private final String[] farm;
    private int current = 0;
    private boolean full = false;
    private boolean empty = true;

    // Constructors
    public Monitor(int farmSize) {
        this.farm = new String[farmSize];
    }

    // Methods
    public synchronized void put(String vegetable) throws InterruptedException {
        while (full) wait();

        farm[current] = vegetable;
        current +=1;
        empty = false;
        full = (current >= farm.length);
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while(empty) wait();

        String vegetable = farm[current-1];
        System.out.println(">> Vendiendo un " + vegetable + "...");
        current -=1;
        full = false;
        empty = (current == 0);
        notifyAll();

        return vegetable;
    }
}