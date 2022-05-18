package giai_thuat;

public class huhu {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int[] arr1 = {1, 2, 3};
        System.out.println(hi(arr));
        System.out.println(hi(arr1));
    }

    public static boolean hi(int[] arg1) {
        int n = arg1.length / 2 + 1;
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < n-1; i++) {
            sum += arg1[i];
        }
        for (int i = n; i < arg1.length; i++) {
            sum1 += arg1[i];
        }
        System.out.println(sum+","+sum1);
        return sum == sum1;

    }
//    for (int i = 0; i < arg1.length; i++) {
//        if (arg1.length<4){
//            return false;
//        }
//        if ((arg1[i] + arg1[i + 1]) == arg1[i + 2]) {
//            return true;
//        }
//    }
//        return false;
}
