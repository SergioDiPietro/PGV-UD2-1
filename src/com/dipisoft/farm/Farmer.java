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
        String[] vegetables = {"lettuce","cabbage","onion","spinach","potato","celery","asparagus","radish","broccoli",
                "artichoke","tomato","cucumber","eggplant","carrot","green bean"};
        String vegetable = vegetables[(int)(Math.random() * vegetables.length)];

        try {
            System.out.println(">> Cultivando " + vegetable + "...");
            sleep(3000);
            System.out.println("!! Se ha cultivado 1 " + vegetable);
            farm.put(vegetable);
            //sleep(2000 + (int)(Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}