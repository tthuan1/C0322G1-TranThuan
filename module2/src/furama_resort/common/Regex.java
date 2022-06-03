package furama_resort.common;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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

    public static String regexServiceCodeRoom() {
        String serviceCode = CheckException.checkString();
        while (!serviceCode.matches(REGEX_SERVICE_CODE_VILLA)) {
            System.out.println("Nhập không đúng định dạng mã dịch vụ !!" +
                    "\nYêu cầu nhập lại lại đây theo định dạng SVRO-YYYY: ");
            serviceCode = scanner.nextLine();
        }
        return serviceCode;
    }

    public static String regexServiceCodeVilla() {
        String serviceCode = CheckException.checkString();
        while (!serviceCode.matches(REGEX_SERVICE_CODE_VILLA)) {
            System.out.println("Nhập không đúng định dạng mã dịch vụ !!" +
                    "\nYêu cầu nhập lại lại đây theo định dạng SVVL-YYYY: ");
            serviceCode = scanner.nextLine();
        }
        return serviceCode;
    }

    public static String regexServiceCodeHouse() {
        String serviceCode = CheckException.checkString();
        while (!serviceCode.matches(REGEX_SERVICE_CODE_HOUSE)) {
            System.out.println("Nhập không đúng định dạng mã dịch vụ !!" +
                    "\nYêu cầu nhập lại lại đây theo định dạng SVHO-YYYY: ");
            serviceCode = scanner.nextLine();
        }
        return serviceCode;
    }

    public static String regexName() {
        String name = CheckException.checkString();
        while (!name.matches(REGEX_NAME)) {
            System.out.println("Nhập không đúng định dạng  !!" +
                    "\nYêu cầu nhập lại: ");
            name = scanner.nextLine();
        }
        return name;
    }

    public static Double regexArea() {
        Double area = CheckException.checkparseDouble();
        while (!String.valueOf(area).matches(REGEX_AREA)) {
            System.out.println("Nhập số lớn hơn 30 !!" +
                    "\nYêu cầu nhập lại: ");
            area = CheckException.checkparseDouble();
        }
        return area;
    }

    public static int regexRentalCosts() {
        Integer regexRentalCosts = CheckException.checkparseInt();
        while (!String.valueOf(regexRentalCosts).matches(REGEX_RENTAL_COSTS)) {
            System.out.println("Nhập không phải số dương !!" +
                    "\nYêu cầu nhập lại: ");
            regexRentalCosts = CheckException.checkparseInt();
        }
        return regexRentalCosts;
    }

    public static int regexNumberPeople() {
        int numberPeople = CheckException.checkparseInt();

        while (!String.valueOf(numberPeople).matches(REGEX_NUMBER_PEOPLE)) {
            System.out.println("Nhập không đúng định dạng !!" +
                    "\nYêu cầu nhập lại: ");
            numberPeople = CheckException.checkparseInt();
        }
        return numberPeople;
    }

    public static int regexNumberOfFloors() {
        int numberOfFloors = CheckException.checkparseInt();
        while (!String.valueOf(numberOfFloors).matches(REGEX_NUMBER_FOORS)) {
            System.out.print("Nhập số không  !!" +
                    "\nYêu cầu nhập lại: ");
            numberOfFloors = CheckException.checkparseInt();
        }
        return numberOfFloors;
    }

    public static void regexAge(String date) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(REGEX_DATE_OF_BIRTH, date)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(date, formatter);
                    LocalDate dateNow = LocalDate.now();
                    int year = Period.between(age, dateNow).getYears();
                    if (year < 100 && year > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Tuổi phải lớn hơn 18 và bé hơn 100");
                    }
                } else {
                    throw new AgeException("Định dạng nhập vào sai");
                }
            } catch (AgeException e) {
                System.out.println(e.getMessage());
                date = scanner.nextLine();
            }
        }
    }
}
