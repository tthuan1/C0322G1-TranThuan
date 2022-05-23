package company.until;

import company.model.Person;

import java.util.Comparator;

public class ComparePenson implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.payroll().equals(o2.payroll())) {
            return o1.getName().compareTo(o2.getName());
        }
        return (int) (o1.payroll() - o2.payroll());
    }
}
