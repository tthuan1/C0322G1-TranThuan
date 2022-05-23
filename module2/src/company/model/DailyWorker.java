package company.model;

public class DailyWorker extends Person {
    private Integer soNgayCong;

    public DailyWorker() {
    }


    public DailyWorker(String name, String dateOfBirth, String address, Integer soNgayCong) {
        super(name, dateOfBirth, address);
        this.soNgayCong = soNgayCong;
    }

    public Integer getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(Integer soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    @Override
    public String toString() {
        return "Nhân viên công nhật- " + super.toString() +
                ", soNgayCong: " + soNgayCong;
    }

    @Override
    public Double payroll() {
        return soNgayCong * 120.000;
    }
}
