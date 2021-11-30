package com.dipisoft;

import com.dipisoft.farm.Customer;
import com.dipisoft.farm.Farmer;
import com.dipisoft.farm.Monitor;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(10);

        Farmer farmer1 = new Farmer(monitor, 10);
        Farmer farmer2 = new Farmer(monitor, 5);
        Customer customer1 = new Customer(monitor, 3);
        Customer customer2 = new Customer(monitor, 1);
        Customer customer3 = new Customer(monitor, 4);
        Customer customer4 = new Customer(monitor, 2);

        farmer1.start();
        farmer2.start();

        farmer1.setPriority(Thread.MAX_PRIORITY);
        farmer2.setPriority(Thread.MAX_PRIORITY);

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
    }
}