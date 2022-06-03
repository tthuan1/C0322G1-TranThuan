package furama_resort.model;

import furama_resort.model.facility.Facility;
import furama_resort.model.person.Customer;

public class Booking {
    private Integer bookingCode;
    private String startDay;
    private String endDate;
    private Integer customerCode;
    private String serviceCode;


    public Booking(Integer bookingCode, String startDay, String endDate, Integer customerCode, String serviceCode) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
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

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String coverToString() {
        return bookingCode +
                "," + startDay +
                "," + endDate +
                "," + customerCode +
                "," + serviceCode/* +
                "," + facility.getRentalType()*/;
    }

    @Override
    public String toString() {
        return "Booking- " +
                " mã booking: " + bookingCode +
                ", ngày bắt đầu: " + startDay +
                ", ngày kết thúc: " + endDate +
                ", mã khách hàng: " + customerCode+
                ", mã dịch vụ: " + serviceCode/*+
                ", loại dịch vụ: " + facility.getRentalType()*/;
    }
}
