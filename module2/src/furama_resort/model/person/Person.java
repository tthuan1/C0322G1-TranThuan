package furama_resort.model.person;

public abstract class Person {
    private String name;
    private String date;
    private String gender;
    private String identityCard;
    private String numberPhone;

    public Person() {
    }

    public Person(String name, String date, String gender, String identityCard, String numberPhone) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.identityCard = identityCard;
        this.numberPhone = numberPhone;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    abstract void coverToString();

    @Override
    public String toString() {
        return ", name: " + name +
                ", date: " + date +
                ", gender: " + gender +
                ", identityCard: " + identityCard +
                ", numberPhone: " + numberPhone;
    }
}
