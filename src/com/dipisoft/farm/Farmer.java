package com.dipisoft.farm;

public class Farmer extends Thread {
    // Attribs
    private Monitor farm;

    // Constructors
    public Farmer(Monitor farm) {
        this.farm = farm;
    }

    // Methods
    @Override
    public void run() {
        String vegetable = "lechuga";

        try {
            farm.put(vegetable);
            System.out.println("(+) Se ha producido el vegetal: " + vegetable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}