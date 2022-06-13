package school.common;

import furama_resort.common.AgeException;
import furama_resort.common.CheckException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    public static final String REGEX_SO_DUONG = "^\\d*$";
    public static final String REGEX_DATE_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String REGEX_CODE_STUDEN = "^\\d{8}$";
    public static final String REGEX_DIEM_TB = "^10{1}||[0-9]$";

    public static String regexMaStudent() {
        String codeStudent = CheckException.checkString();
        while (!codeStudent.matches(REGEX_CODE_STUDEN)) {
            System.out.println("Hãy nhập 8 số !!" +
                    "\nYêu cầu nhập lại: ");
            codeStudent = CheckException.checkString();
        }
        return codeStudent;
    }

    public static String regexDiemTB() {
        String codeStudent = CheckException.checkString();
        while (!codeStudent.matches(REGEX_DIEM_TB)) {
            System.out.println("Hãy nhập từ 1 đến 10 số !!" +
                    "\nYêu cầu nhập lại: ");
            codeStudent = CheckException.checkString();
        }
        return codeStudent;
    }

    public static String regexSoDuong() {
        String soDuong = CheckException.checkString();
        while (!soDuong.matches(REGEX_SO_DUONG)) {
            System.out.println("NHãy nhập số dương !!" +
                    "\nYêu cầu nhập lại: ");
            soDuong = CheckException.checkString();
        }
        return soDuong;
    }
    public static String regexAge1() {
         String date = CheckException.checkString();
        while (!date.matches(REGEX_DATE_OF_BIRTH)) {
            System.out.println("Nhập sai !!" +
                    "\nYêu cầu nhập lại: ");
            date = CheckException.checkString();
        }
        return date;
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
                    throw new AgeException("Nhập sai, yêu cầu nhập lại !!");
                }
            } catch (AgeException e) {
                System.out.println(e.getMessage());
                date = scanner.nextLine();
            }
        }
    }


}
