package giai_thuat;

import java.util.Arrays;

public class huhu {

    public static void main(String[] args) {
//        int n = 10;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i < n / 2) {
//                    if (j >= i && j < (n - i)) {
//                        System.out.print(" * ");
//                    } else {
//                        System.out.print("   ");
//                    }
//                } else {
//                    if (j <= i && j >= (n-1 - i)) {
//                        System.out.print(" * ");
//                    } else {
//                        System.out.print("   ");
//                    }
//                }
//            }
//            System.out.println();
//        }

        test("abcbdcef");
    }
    public static void test(String s){
        String[] hi= s.split("");
        String[] temp=new String[hi.length];
        String a;
        for (int i = 0; i < hi.length; i++) {
             a= hi[i];
            for (int j = i+1; j < hi.length; j++) {
                if (a.equals( hi[j])){
                    temp[j]=a;
                }
            }
        }
        int length=0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] !=null){
                length++;
            }
        }
        String[] ok= new String[length];
        int j=0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] !=null){
                ok[j]=temp[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(ok));

    }


}
