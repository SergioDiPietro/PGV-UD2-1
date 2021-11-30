package com.dipisoft.farm;

public class Customer extends Thread {
    // Attribs
    private final Monitor farm;
    private final int requestedVegetables;

    // Constructors
    public Customer(Monitor farm, int requestedVegetables) {
        this.farm = farm;
        this.requestedVegetables = requestedVegetables;
    }

    // Methods
    @Override
    public void run() {
        for (int i = 0; i < requestedVegetables; i++) {
            try {
                String vegetable = farm.get();
                sleep(3000);
                System.out.println("(-) Se ha vendido 1 " + vegetable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
