package ss11_stack_queue.exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class Map {
    public static void map() {
        Scanner scanner = new Scanner(System.in);
        String str = "qazqazwsxedcrfvrf.tttttt";
        String newStr = str.toLowerCase();
        String[] arr = newStr.split("");

        TreeMap<String, Integer> map1 = new TreeMap<>();

        for (String s : arr) {
            if (map1.containsKey(s)) {
                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }
        }

        System.out.println("Nhập kí tự muốn đếm: ");
        String charInput = scanner.nextLine();
        boolean flag = true;

        for (String s : arr) {
            if (s.equals(charInput)) {
                System.out.println(map1.get(s));
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(charInput + " không có");
        }

    }

    public static void main(String[] args) {
        map();
    }
}
