package ss11_stack_queue.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Palindrome {
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        String newStr = str.toLowerCase();
        String[] arrStr = newStr.split("");
        queue.addAll(Arrays.asList(arrStr));

        boolean check = true;
        for (int i = arrStr.length - 1; i > 0; i--) {
            if (!queue.poll().equals(arrStr[i])) {
                check = false;
            }
        }
        if (check) {
            System.out.println("ok");
        } else {
            System.out.println("sai");
        }
    }
}
