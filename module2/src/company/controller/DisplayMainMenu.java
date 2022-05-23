package company.controller;

import company.severis.ISeveris;
import company.severis.impl.ManageWithArray;
import company.severis.impl.ManageWithArrayList;
import company.severis.impl.ManageWithLinkedList;
import company.severis.impl.ManageWithMap;

import java.util.Scanner;

public class DisplayMainMenu {
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.print("1: Hiển thị bằng array\n" +
                    "2. Hiển thị bằng arrayList\n" +
                    "3. Hiển thị bằng LinkedList\n" +
                    "4. Hiển thị bằng Map\n" +
                    "5. Thoát\n" +
                    "Nhập: ");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    ISeveris array = new ManageWithArray();
                    array.disPlay();
                    break;
                case 2:
                    ISeveris arrayList=new ManageWithArrayList();
                    arrayList.disPlay();
                    break;
                case 3:
                    ISeveris linkedList=new ManageWithLinkedList();
                    linkedList.disPlay();
                    break;
                case 4:
                    ISeveris map= new ManageWithMap();
                    map.disPlay();
                    break;
                case 5:
                    System.exit(5);
                    break;
                default:
                    System.out.println("Nhập lại!!");
                    break;
            }
        }
    }
}
