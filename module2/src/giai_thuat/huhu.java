package giai_thuat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class huhu {

    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n / 2) {
                    if (j >= i && j < (n - i)) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" - ");
                    }
                } else {
                    if (j <= i && j >= (n-1 - i)) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" - ");
                    }
                }
            }
            System.out.println();
        }
    }


}
