package furama_resort.model.person;

public class Customer extends Person {
    private String customerCode;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String customerCode,String name, String date, String gender, String identityCard,
                    String numberPhone, String email,
                    String customerType, String address) {
        super(name, date, gender, identityCard, numberPhone, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String coverToString() {
        return customerCode + "," + getName() + "," + getDate() + "," + getGender() + "," + getIdentityCard() + "," + getPhoneNumber() + ","
                + getEmail() + "," + customerType + "," + address;
    }

    @Override
    public String toString() {
        return "Customer- " +
                "customerCode: " + customerCode +
                super.toString() +
                ", customerType: " + customerType +
                ", address: " + address;
    }
}
