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
        try {
            farm.get();
            sleep(1000);
            System.out.println("!! Se ha vendido 1 vegetal");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
