package furama_resort.model.facility;

import java.util.Objects;

public abstract class Facility {
    //mã dịch vụ,Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê
    private String serviceCode;
    private String serviceName;
    private Double usableArea;
    private Integer rentalCosts;
    private Integer maximumPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceCode, String serviceName, Double usableArea,
                    Integer rentalCosts, Integer maximumPeople, String rentalType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Integer getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Integer rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public Integer getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(Integer maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    abstract String coverToString();

    @Override
    public String toString() {
        return " mã dịch vụ: " + serviceCode +
                ", tên dịch vụ: " + serviceName +
                ", diện tích sử dụng: " + usableArea +
                ", chi phí thuê: " + rentalCosts +
                ", số lượng người tối đa: " + maximumPeople +
                ", kiểu thuê: " + rentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(serviceCode, facility.serviceCode) && Objects.equals(serviceName, facility.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceCode, serviceName);
    }
}
