package furama_resort.model.facility;

public class House extends Facility {
    //Tiêu chuẩn phòng, Số tầng.
    private String roomStandard;
    private Integer numberOfFloors;

    public House() {
    }

    public House(String serviceCode, String serviceName, Double usableArea, Integer rentalCosts, Integer maximumPeople, String rentalType, String roomStandard, Integer numberOfFloors) {
        super(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String coverToString() {
        return getServiceCode() +
                "," + getServiceName() +
                "," + getUsableArea() +
                "," + getRentalCosts() +
                "," + getMaximumPeople() +
                "," + getRentalType() +
                "," + roomStandard +
                "," + numberOfFloors;
    }

    @Override
    public String toString() {
        return "House- " + super.toString() +
                ", tiêu chuẩn phòng: " + roomStandard +
                ", số tầng: " + numberOfFloors;
    }
}
