package school.model;

public abstract class Person {
    //Id, Tên, Giới tính, Ngày sinh, Địa chỉ,
    private Integer id;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;

    public Person() {
    }

    public Person(Integer id, String name, String gender, String dateOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    abstract String coverToString();

    @Override
    public String toString() {
        return " id: " + id +
                ", name: " + name +
                ", gender: " + gender +
                ", dateOfBirth: " + dateOfBirth +
                ", address: " + address;
    }
}
