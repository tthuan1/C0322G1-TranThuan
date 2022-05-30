package furama_resort.model;

public class Booking {
    private Integer bookingCode;
    private String startDay;
    private String endDate;
    private Integer customerCode;
    private String serviceName;
    private String typeOfService;

    public Booking() {
    }

    public Booking(Integer codeBooking, String startDay, String endDate, Integer customerCode, String serviceName, String typeOfService) {
        this.bookingCode = codeBooking;
        this.startDay = startDay;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public Integer getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(Integer bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Integer customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }


    @Override
    public String toString() {
        return "Booking- " +
                " mã booking: " + bookingCode +
                ", ngày bắt đầu: " + startDay +
                ", ngày kết thúc: " + endDate +
                ", mã khách hàng: " + customerCode +
                ", tên dịch vụ: " + serviceName +
                ", loại dịch vụ: " + typeOfService;
    }
}
