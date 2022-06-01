package furama_resort.common;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_SERVICE_CODE_VILLA = "^(SVVL-)\\d{4}$";
    public static final String REGEX_SERVICE_CODE_HOUSE = "^(SVHO-)\\d{4}$";
    public static final String REGEX_SERVICE_CODE_ROOM = "^(SVRO-)\\d{4}$";
    public static final String REGEX_NAME = "^[A-Z][A-Za-z]+[0-9]*$";
    public static final String REGEX_AREA = "^([3-9]\\d|\\d{3,}).?\\d*$";
    public static final String REGEX_RENTAL_COSTS = "^\\d+.?\\d*$";
    public static final String REGEX_NUMBER_PEOPLE = "^(1)\\d$|^[1-9]?$";
    public static final String REGEX_NUMBER_FOORS = "^\\d*$";
    public static final String REGEX_DATE_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static void regexServiceCodeRoom(String serviceCode) {
        while (!serviceCode.matches(REGEX_SERVICE_CODE_ROOM)) {
            System.out.println("Nhập không đúng định dạng mã dịch vụ !!" +
                    "\nYêu cầu nhập lại lại đây theo định dạng SVRO-YYYY: ");
            serviceCode = scanner.nextLine();
        }
    }

    public static void regexServiceCodeVilla(String serviceCode) {
        while (!serviceCode.matches(REGEX_SERVICE_CODE_VILLA)) {
            System.out.println("Nhập không đúng định dạng mã dịch vụ !!" +
                    "\nYêu cầu nhập lại lại đây theo định dạng SVVL-YYYY: ");
            serviceCode = scanner.nextLine();
        }
    }

    public static void regexServiceCodeHouse(String serviceCode) {
        while (!serviceCode.matches(REGEX_SERVICE_CODE_HOUSE)) {
            System.out.println("Nhập không đúng định dạng mã dịch vụ !!" +
                    "\nYêu cầu nhập lại lại đây theo định dạng SVHO-YYYY: ");
            serviceCode = scanner.nextLine();
        }
    }

    public static void regexName(String name) {
        while (!name.matches(REGEX_NAME)) {
            System.out.println("Nhập không đúng định dạng  !!" +
                    "\nYêu cầu nhập lại: ");
            name = scanner.nextLine();
        }
    }

    public static void regexArea(String area) {
        while (!area.matches(REGEX_AREA)) {
            System.out.println("Nhập không đúng định dạng !!" +
                    "\nYêu cầu nhập lại: ");
            area = scanner.nextLine();
        }
    }

    public static void regexRentalCosts(String rentalCosts) {
        while (!rentalCosts.matches(REGEX_RENTAL_COSTS)) {
            System.out.println("Nhập không phải số dương !!" +
                    "\nYêu cầu nhập lại: ");
            rentalCosts = scanner.nextLine();
        }
    }

    public static void regexNumberPeople(String numberPeople) {
        while (!numberPeople.matches(REGEX_NUMBER_PEOPLE)) {
            System.out.println("Nhập không đúng định dạng !!" +
                    "\nYêu cầu nhập lại: ");
            numberPeople = scanner.nextLine();
        }
    }

    public static void regexNumberOfFloors(String numberOfFloors) {
        while (!numberOfFloors.matches(REGEX_NUMBER_FOORS)) {
            System.out.println("Nhập không đúng định dạng !!" +
                    "\nYêu cầu nhập lại: ");
            numberOfFloors = scanner.nextLine();
        }
    }

//    public static void regexDateOfBirth(String dateOfBirth) {
//        while (!dateOfBirth.matches(REGEX_DATE_OF_BIRTH)) {
//            System.out.println("Nhập không đúng định dạng !!" +
//                    "\nYêu cầu nhập lại: ");
//            dateOfBirth = scanner.nextLine();
//        }
//    }

    public static String regexAge(String date) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(REGEX_DATE_OF_BIRTH, date)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(date, formatter);
                    LocalDate dateNow = LocalDate.now();
                    int year = Period.between(age, dateNow).getYears();
                    if (year < 100 && year > 18) {
                        check=false;
                    }else {
                        throw new AgeException("Tuổi phải lớn hơn 18 và bé hơn 100");
                    }
                }else {
                    throw new AgeException("Định dạng nhập vào sai");
                }
            }catch (AgeException e){
                System.out.println(e.getMessage());
                date=scanner.nextLine();
            }
        }
        return date;
    }
}
