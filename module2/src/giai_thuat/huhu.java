package giai_thuat;

import java.util.Arrays;

public class huhu {

    public static void main(String[] args) {
        int[]hi={1,2,3,3};


        System.out.println(solution(hi));
    }

    public static boolean solution(int[] a) {
        for(int i=0;i<=a.length;i++){
            int s1 = 0;
            int s2=0;
            for(int y = 0; y <i;y++){
                s1 = s1 + a[y];
            }
            for(int z = i+1; z <a.length;z++){
                s2 = s2 + a[z];
            }
            if(s1== s2){
                return true;
            }
        }
        return false;
    }


}
