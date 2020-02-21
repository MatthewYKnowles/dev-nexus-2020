package com.greatersum.rental;

public class Employee {
    private final int salary;
    private final double taxToWithhold;

    Employee(int salary, double taxToWithhold) {
        this.salary = salary;
        this.taxToWithhold = taxToWithhold;
    }

    public int getSalary() {
        return salary;
    }

    public double getTaxToWithhold() {
        return taxToWithhold;
    }
}
