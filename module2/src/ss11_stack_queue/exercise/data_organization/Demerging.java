package ss11_stack_queue.exercise.data_organization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) {
        Queue<String> queueMale = new LinkedList<>();
        Queue<String> queueFemale = new LinkedList<>();
        List<Person> list = new ArrayList<>();
        Person person = new Person("Thuận", "nam", "18/09/1999");
        Person person1 = new Person("thu", "nữ", "18/07/1999");
        Person person2 = new Person("Hoàn", "nam", "18/08/1999");
        Person person3 = new Person("hoà", "nữ", "18/10/1999");
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        for (Person persons : list) {
            if (persons.getGender().equals("nữ")) {
                queueFemale.add(String.valueOf(persons));
            } else {
                queueMale.add(String.valueOf(persons));
            }
        }
        System.out.println("\tMale list:");
        for (String male : queueMale) {
            System.out.println(male);
        }
        System.out.println("\tFemale list:");
        for (String female : queueFemale) {
            System.out.println(female);
        }
    }
}
