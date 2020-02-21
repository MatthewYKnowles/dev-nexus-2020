package com.greatersum.rental;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SalaryTests {
    @Test
    public void give2000DollarRaise() {
        Employee employee = new Employee(50000, 10000);
        Salary salary = new Salary();
        Employee employeeWithSalary = salary.giveRaise(employee, 2000);
        assertThat(employeeWithSalary.getSalary(), is(52000));
    }
}
