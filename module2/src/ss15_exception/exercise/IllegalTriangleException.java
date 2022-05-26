package ss15_exception.exercise;

import java.util.Scanner;

public class IllegalTriangleException {
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
            } catch (TriangleException e) {
                System.err.println(e.getMessage());
            }catch (NumberFormatException e){
                System.err.println("Bạn nhập không phải là số xin nhập lại!!");
            }
        }
    }

    public static void triangle(int a,int b,int c) throws TriangleException{
            if (a+b<=c||a+c<=b||b+c<=a){
                throw new TriangleException("Không phải là tam giác");
            } else if (a<=0||b<=0||c<=0) {
                throw new TriangleException("Số nhập có cạnh bé hơn hoặc bằng 0");
            }  else {
                throw new TriangleException("Là tam giác");
            }
    }
}
