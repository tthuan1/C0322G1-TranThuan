package company.model;

import java.math.BigDecimal;
import java.util.Comparator;

public abstract class Person implements Comparable<Person> {
    private String name;
    private String dateOfBirth;
    private String address;

    public Person() {
    }

    public Person(String name, String dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //
    public abstract Double payroll();

    @Override
    public String toString() {
        return " name: " + name +
                ", dateOfBirth: " + dateOfBirth +
                ", address: " + address +
                ", số lương: " + new BigDecimal(payroll());
    }

    @Override
    public int compareTo(Person o) {
        return (int) (payroll()-o.payroll());
    }
}
