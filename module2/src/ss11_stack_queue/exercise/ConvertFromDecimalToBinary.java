package ss11_stack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class ConvertFromDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần chuyển đổi: ");
        int a = Integer.parseInt(scanner.nextLine());
        int b;
        do {
            b = a / 2;
            stack.push(a % 2);
            a = b;
        } while (b != 0);
        System.out.print("Đã chuyển đổi: ");
        for (int i = 0; i < stack.size(); ) {
            System.out.print(stack.pop());
        }
    }
}
