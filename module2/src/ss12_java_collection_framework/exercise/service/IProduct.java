package ss12_java_collection_framework.exercise.service;

public interface IProduct {
    void add();
    void display();
    void delete(int id);
    void search(String name);
    void update(int idCheck);
    void sortUpAscending();
    void sortDescending();
}