package ss15_exception.exercise;

import java.util.Scanner;

public class TriangleCheck {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            try {
                System.out.print("\nnhập a: ");
                int a=Integer.parseInt(scanner.nextLine());
                System.out.print("nhập b: ");
                int b=Integer.parseInt(scanner.nextLine());
                System.out.print("nhập c: ");
                int c=Integer.parseInt(scanner.nextLine());
                triangle(a,b,c);
            } catch (IllegalTriangleException e) {
                System.err.println(e.getMessage());
            }catch (NumberFormatException e){
                System.err.println("Bạn nhập không phải là số xin nhập lại!!");
            }
        }
    }

    public static void triangle(int a,int b,int c) throws IllegalTriangleException {
            if (a+b<=c||a+c<=b||b+c<=a){
                throw new IllegalTriangleException("Không phải là tam giác");
            } else if (a<=0||b<=0||c<=0) {
                throw new IllegalTriangleException("Số nhập có cạnh bé hơn hoặc bằng 0");
            }  else {
                throw new IllegalTriangleException("Là tam giác");
            }
    }
}
