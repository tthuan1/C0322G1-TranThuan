package company.controller;

import company.severis.ISeveris;
import company.severis.impl.ManageWithArray;
import company.severis.impl.ManageWithArrayList;
import company.severis.impl.ManageWithLinkedList;

import java.util.Scanner;

public class DisplayMainMenu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.print("1: Hiển thị bằng array\n" +
                    "2. Hiển thị bằng arrayList\n" +
                    "3. Hiển thị bằng LinkedList\n" +
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
                default:
                    System.out.println("Nhập lại!!");
                    break;
            }
        }
    }
}
