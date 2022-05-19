package giai_thuat;

public class huhu {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 100, 2, 3};
        int[] arr0 = {1, 2, 3, 3};
        int[] arr1 = {1, 2, 3};
//        System.out.println(hi(arr));
//        System.out.println(hi(arr0));
        System.out.println(hi(arr1));
    }

    public static boolean hi(int[] arg1) {
        int sum = 0;
        int sum1 = 0;
        int n = 1;
        boolean a = false;
        while ( n  < arg1.length || !a) {
            for (int i = 0; i < n; i++) {
                sum += arg1[i];
            }
            for (int i = n + 1; i < arg1.length; i++) {
                sum1 += arg1[i];
            }
            a = (sum == sum1);
            sum = sum1 = 0;
            n++;
        }
        return a;
    }
}
