package furama_resort.model;

public class Contract {
    private Integer contractsCode;
    private Integer bookingCode;
    private Integer deposits;
    private Integer totalMoney;
    private String customerCode;

    public Contract() {
    }

    public Contract(Integer contractsCode, Integer bookingCode, Integer deposits, Integer totalMoney, String customerCode) {
        this.contractsCode = contractsCode;
        this.bookingCode = bookingCode;
        this.deposits = deposits;
        this.totalMoney = totalMoney;
        this.customerCode = customerCode;
    }

    public Integer getContractsCode() {
        return contractsCode;
    }

    public void setContractsCode(Integer contractsCode) {
        this.contractsCode = contractsCode;
    }

    public Integer getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(Integer bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Integer getDeposits() {
        return deposits;
    }

    public void setDeposits(Integer deposits) {
        this.deposits = deposits;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String coverToString() {
        return contractsCode +
                "," + bookingCode +
                "," + deposits +
                "," + totalMoney +
                "," + customerCode;
    }

    @Override
    public String toString() {
        return "Contract- " +
                "mã hợp đồng: " + contractsCode +
                ", mã booking: " + bookingCode +
                ", số tiền cọc trước: " + deposits +
                ", tổng số tiền thanh toán: " + totalMoney +
                ", mã khách hàng: " + customerCode;
    }
}
