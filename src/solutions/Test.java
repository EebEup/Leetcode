package solutions;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        int[] a =new int[] {1};
        change(a);
        System.out.println(a[0]);

    }



    static void change(int[] a){
        a[0]=0;
    }

}
