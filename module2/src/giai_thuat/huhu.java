package giai_thuat;

import java.util.Arrays;

public class huhu {

    public static void main(String[] args) {
        int height = 10;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == height)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }



}
