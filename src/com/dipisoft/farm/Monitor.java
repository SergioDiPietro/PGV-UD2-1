package com.dipisoft.farm;

public class Monitor {

    // Attribs
    private String farm[];
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

        //System.out.println(">> Vegetales en huerto: " + current);
        // Posible implementación: imprimir representación gráfica del huerto (tabla)
        // que muestre una tabla con cada posición y cada vegetal
    }

    public synchronized String get() throws InterruptedException {
        while(empty) wait();

        String vegetable = farm[current-1];
        System.out.println(">> Vendiendo un " + vegetable + "...");
        current -=1;
        full = false;
        empty = (current == 0);
        notifyAll();

        //System.out.println(">> Vegetales en huerto: " + current);

        return vegetable;
    }
}