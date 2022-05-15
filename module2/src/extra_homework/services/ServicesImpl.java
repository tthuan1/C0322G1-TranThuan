package extra_homework.services;

import extra_homework.model.Person;
import extra_homework.model.Student;
import extra_homework.model.Teacher;

public class ServicesImpl implements Iservices {


    @Override
    public void add() {
        Person student=new Student();
        Person student1=new Teacher();
        Person[] persons=new Person[4];
        persons[0]=new Student("01","Thuận",18,"Nam",45);
        persons[1]=new Student("02","Hoàn",18,"Nam",45);
        persons[2]=new Teacher("03","Chiến",19,"Nam",100000);
        persons[3]=new Teacher("04","Quang",23,"Nam",80000);
    }

    @Override
    public void display() {
    }
    @Override
    public void delete() {

    }

    @Override
    public void search() {
        Student student=new Student();
    }


}
