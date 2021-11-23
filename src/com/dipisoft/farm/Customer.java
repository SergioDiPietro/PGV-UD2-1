package com.dipisoft.farm;

public class Customer extends Thread {
    // Attribs
    private Monitor farm;

    // Constructors
    public Customer(Monitor farm) {
        this.farm = farm;
    }

    // Methods
    @Override
    public void run() {
        String vegetable;

        try {
            vegetable = farm.get();
            System.out.println("(-) Se ha vendido el vegetal: " + vegetable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
