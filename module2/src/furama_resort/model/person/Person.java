package furama_resort.model.person;

public abstract class Person {
    private String name;
    private String date;
    private String gender;
    private String identityCard;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, String date, String gender, String identityCard, String numberPhone, String email) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.identityCard = identityCard;
        this.phoneNumber = numberPhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    abstract String coverToString();

    @Override
    public String toString() {
        return  ", name: " + name +
                ", dateOfBirth: " + date +
                ", gender: " + gender +
                ", identityCard: " + identityCard +
                ", phoneNumber: " + phoneNumber +
                ", email: " + email;
    }
}
