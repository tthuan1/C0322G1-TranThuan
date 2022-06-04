package furama_resort.common;

public class InputInformation {
    public static String gender() {
        String gender = null;
        while (gender == null) {
            System.out.print("-------- Nhập giới tính ---------\n" +
                    "\t1. Nam \n" +
                    "\t2. Nữ \n" +
                    "\t3. Khác \n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    gender = "Nam";
                    break;
                case 2:
                    gender = "Nữ";
                    break;
                case 3:
                    gender = "Khác";
                default:
                    System.err.println("Chọn không đúng vui lòng nhập lại!!");
            }
        }
        return gender;
    }

    public static String level() {
        String level = null;
        while (level == null) {
            System.out.print("--------Nhập trình độ nhân viên---------\n" +
                    "\t1. Trung cấp \n" +
                    "\t2. Cao đẳng \n" +
                    "\t3. Đại học \n" +
                    "\t4. Sau đại học \n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    level = "Trung cấp";
                    break;
                case 2:
                    level = "Cao đẳng";
                    break;
                case 3:
                    level = "Đại học";
                    break;
                case 4:
                    level = "Sau đại học";
                    break;
                default:
                    System.err.println("Chọn không đúng vui lòng nhập lại!!");
            }
        }
        return level;
    }

    public static String position() {
        String position = null;
        while (position == null) {
            System.out.print("--------Nhập vị trí nhân viên---------\n" +
                    "\t1. Lễ tân \n" +
                    "\t2. Phục vụ \n" +
                    "\t3. Chuyên viên \n" +
                    "\t4. Giám sát \n" +
                    "\t5. Quản lý \n" +
                    "\t6. Giám đốc \n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    position = "Lễ tân";
                    break;
                case 2:
                    position = "Phục vụ";
                    break;
                case 3:
                    position = "Chuyên viên";
                    break;
                case 4:
                    position = "Giám sát";
                    break;
                case 5:
                    position = "Quản lý";
                    break;
                case 6:
                    position = "Giám đốc";
                    break;
                default:
                    System.err.println("Chọn không đúng vui lòng nhập lại!!");
            }
        }
        return position;
    }

    public static String customerType() {
        String customerType = null;
        while (customerType == null) {
            System.out.print("--------Nhập loại khách hàng---------\n" +
                    "\t1. Diamond \n" +
                    "\t2. Platinium \n" +
                    "\t3. Gold \n" +
                    "\t4. Silver \n" +
                    "\t5. Member \n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    customerType = "Diamond";
                    break;
                case 2:
                    customerType = "Platinium";
                    break;
                case 3:
                    customerType = "Gold";
                    break;
                case 4:
                    customerType = "Silver";
                    break;
                case 5:
                    customerType = "Member";
                    break;
                default:
                    System.out.println("Nhập lại!!");
            }
        }
        return customerType;
    }

    public static String rentalType() {
        String rentalType = null;
        while (rentalType == null) {
            System.out.print("--------Nhập kiểu thuê---------\n" +
                    "\t1. Thuê theo năm \n" +
                    "\t2. Thuê theo tháng \n" +
                    "\t3. Thuê theo ngày \n" +
                    "\t4. Thuê theo giờ \n" +
                    "\tEnter: ");
            int choose = CheckException.checkparseInt();
            switch (choose) {
                case 1:
                    rentalType = "Thuê theo năm";
                    break;
                case 2:
                    rentalType = "Thuê theo tháng";
                    break;
                case 3:
                    rentalType = "Thuê theo ngày";
                    break;
                case 4:
                    rentalType = "Thuê theo giờ";
                    break;
                default:
                    System.out.println("Nhập lại!!");
            }
        }
        return rentalType;
    }
}
