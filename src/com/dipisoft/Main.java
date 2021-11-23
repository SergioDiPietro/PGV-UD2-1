package com.dipisoft;

import com.dipisoft.farm.Customer;
import com.dipisoft.farm.Farmer;
import com.dipisoft.farm.Monitor;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(10);

        Farmer farmer = new Farmer(monitor);
        Customer customer = new Customer(monitor);

        farmer.start();
        customer.start();
    }
}