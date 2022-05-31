package furama_resort.model.facility;

public class Villa extends Facility {
    //Tiêu chuẩn phòng, Diện tích hồ bơi, Số tầng.
    private String roomStandard;
    private Integer numberOfFloors;
    private Double poolArea;

    public Villa() {
    }

    public Villa(String serviceCode, String serviceName, Double usableArea, Integer rentalCosts, Integer maximumPeople, String rentalType, String roomStandard, Integer numberOfFloors, Double poolArea) {
        super(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
        this.poolArea = poolArea;
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

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String coverToString() {
//        String serviceCode,
//        String serviceName,
//        Double usableArea,
//        Integer rentalCosts,
//        Integer maximumPeople,
//        String rentalType,
//        String roomStandard,
//        Integer numberOfFloors,
//        Double poolArea
        return getServiceCode() +
                "," + getServiceName() +
                "," + getUsableArea() +
                "," + getRentalCosts() +
                "," + getMaximumPeople() +
                "," + getRentalType() +
                "," + roomStandard +
                "," +numberOfFloors+
                "," + poolArea;
    }

    @Override
    public String toString() {
        return "Villa- " + super.toString() +
                ", tiêu chuẩn phòng: " + roomStandard +
                ", diện tích hồ bơi: " + poolArea +
                ", số tầng: " + numberOfFloors;
    }
}
