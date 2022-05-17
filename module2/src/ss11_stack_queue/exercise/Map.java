package ss11_stack_queue.exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class Map {
    public static void map() {
        Scanner scanner = new Scanner(System.in);
        String str = "qazqazwsxedcrfvrf.";
        String newStr = str.toLowerCase();
        String[] arr = newStr.split("");
        TreeMap<Integer, String> map1 = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map1.put(i, arr[i]);
        }
        System.out.println("Nhập kí tự muốn đếm: ");
        String charInput = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < map1.size(); i++) {
            if (charInput.equals(map1.get(i))) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println(charInput + " không có");
        } else {
            System.out.println(charInput + " xuất hiện: " + count + " lần");
        }
    }

    public static void main(String[] args) {
        map();
    }
}
