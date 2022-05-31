package furama_resort.model.facility;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }
    public Room(String serviceCode) {
        super(serviceCode);
    }

    public Room(String serviceCode, String serviceName, Double usableArea, Integer rentalCosts, Integer maximumPeople, String rentalType, String freeService) {
        super(serviceCode, serviceName, usableArea, rentalCosts, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String coverToString() {
        return getServiceCode() +
                "," + getServiceName() +
                "," + getUsableArea() +
                "," + getRentalCosts() +
                "," + getMaximumPeople() +
                "," + getRentalType() +
                "," + freeService;
    }

    @Override
    public String toString() {
        return "Room- " + super.toString() +
                ", dịch vụ miễn phí: " + freeService;
    }
}
