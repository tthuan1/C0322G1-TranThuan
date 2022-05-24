package ss14_sort_algorithm.exercise;

import java.util.Arrays;

public class InstallInsertionSortAlgorithm {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8};
        System.out.println("After");
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println("Befor");
        System.out.println(Arrays.toString(a));
    }

    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
//          key = phần tử chèn vào trong danh sách con
            int key = arr[i];
//           Vị trí của phần tử cuối cùng ở danh sách con
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
