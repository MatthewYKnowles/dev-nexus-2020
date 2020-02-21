package com.greatersum.rental;

public class Salary {
    Employee giveRaise(Employee employee, int raise) {
        int newSalary = employee.getSalary() + raise;
        double newTaxToWithhold = newSalary * .20;
        return new Employee(newSalary, newTaxToWithhold);
    }
}