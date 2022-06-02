package giai_thuat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class huhu {


    public static void main(String[] args) {
        int[] a = {1,-1, 150, 190, 170, -1, -1, 160, 180};
        //[-1, 150, 160, 170, -1, -1, 180, 190].
        hi(a);
    }

    public static void hi(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min;
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min] && a[j] != -1)
                    min = j;
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }


}
