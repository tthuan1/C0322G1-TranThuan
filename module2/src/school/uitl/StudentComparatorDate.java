package school.uitl;

import furama_resort.model.Booking;
import school.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class StudentComparatorDate implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date1 = LocalDate.parse(o1.getDateOfBirth(), dateTimeFormatter);
        LocalDate date2 = LocalDate.parse(o2.getDateOfBirth(), dateTimeFormatter);

        if (date1.compareTo(date2) > 0) {
            return 1;
        } else if (date1.compareTo(date2) < 0) {
                return -1;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
