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

        System.out.println("[ Total de vegetales " + current + "]");
        // Posible implementación: imprimir representación gráfica del huerto (tabla)
        // que muestre una tabla con cada posición y cada vegetal
        farm[current] = vegetable;
        current +=1;
        empty = false;
        full = (current >= farm.length);
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while(empty) wait();

        String vegetable = farm[current-1];
        System.out.println("[ Total de vegetales " + current + "]");
        current -=1;
        full = false;
        empty = (current == 0);
        notifyAll();

        return vegetable;
    }
}