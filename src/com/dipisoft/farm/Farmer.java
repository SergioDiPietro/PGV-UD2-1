package com.dipisoft.farm;

public class Farmer extends Thread {

    // Attribs
    private final Monitor farm;
    private final int producedVegetables;

    // Constructors
    public Farmer(Monitor farm, int producedVegetables) {
        this.farm = farm;
        this.producedVegetables = producedVegetables;
    }

    // Methods
    @Override
    public void run() {
        String[] vegetables = {"lettuce","cabbage","onion","spinach","potato","celery","asparagus","radish","broccoli",
                "artichoke","tomato","cucumber","eggplant","carrot","green bean"};
        String vegetable = vegetables[(int)(Math.random() * vegetables.length)];

        for (int i = 0; i < producedVegetables; i++) {
            try {
                System.out.println("<< Cultivando " + vegetable + "...");
                sleep((long) (1000 + Math.random() * 1000));
                System.out.println("(+) Se ha cultivado 1 " + vegetable);
                farm.put(vegetable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}