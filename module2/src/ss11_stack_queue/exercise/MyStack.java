package ss11_stack_queue.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        //Đảo ngược phần tử trong mảng số nguyên sử dụng Stack
        Stack<Integer> myStack = new Stack<>();
        Stack<Integer> myStack1 = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử: ");
        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= size; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            int e = Integer.parseInt(scanner.nextLine());
            myStack.push(e);
        }

        for (int i = 1; i <= size; i++) {
            System.out.println("phần tử thứ " + i + ": " + myStack.pop());
        }

//        Đảo ngược chuỗi sử dụng Stack
        Stack<String> wStack = new Stack<>();
        System.out.println("\nNhập chữ : ");
        String str = scanner.nextLine();
        String[] mWord = str.split("");

        System.out.println("Before");
        System.out.println(Arrays.toString(mWord));

        for (String s : mWord) {
            wStack.push(s);
        }
//        String[] outp = new String[wStack.size()];
        for (int i = 0; i < mWord.length; i++) {
            mWord[i] = wStack.pop();
        }
        System.out.println("After");
        System.out.println(Arrays.toString(mWord));
    }
}
