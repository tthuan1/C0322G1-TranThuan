package extra_homework.controllers;

import java.util.Scanner;

public class DisplayMainMenu {
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        boolean flag=false;
        do {
            System.out.print("-------Menu---------\n" +
                    "\t1. Add Student\n" +
                    "\t2. Xóa Student\n" +
                    "\t3. Search Student\n"+
                    "\t4. Thêm mới Teacher\n" +
                    "\t5. Xóa Teacher\n" +
                    "\t6. Tìm kiếm Teacher\n" +
                    "\t7. Exit\n" +
                    "\t Choose: ");
            int choose= Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("Add Student");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    flag=true;
                    System.out.println("Đã thoát");
                    break;
            }
        }while (!flag);
    }
}
