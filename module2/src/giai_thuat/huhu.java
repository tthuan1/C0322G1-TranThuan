package giai_thuat;

import java.util.Arrays;

public class huhu {

    public static void main(String[] args) {

        solution1(9, 13);
    }

    public static int solution(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (i < 10) {
                count++;
            }else {
                i-10
            }
        }
        return count;
    }
    public static int solution1(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (i < 10) {
                count++;
            }else {

            }
        }
        return count;
    }


}
