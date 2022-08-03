package giai_thuat;

import java.util.Arrays;

public class huhu {

    public static void main(String[] args) {
        int arr[]={3,2,1};
        int n=10;
        int result=0;
        int min=arr[0];
        int max=arr[0];
        for(int i=0; i<arr.length;i++){

            if( min>=arr[i]){
                min=arr[i];
            };
            if(max<arr[i]){
                max=arr[i];
            };
        }
        if (n > min){
            result=n-min+max;
        }else{
            result = n;
        }
        System.out.println(result);
        System.out.println(min);
        System.out.println(max);
    }



}
