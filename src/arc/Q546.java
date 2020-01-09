package arc;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q546 {
    public static int mySqrt(int x) {
        if(x==0) return 0;
        int result =0;
        for(;result*result<=x;result++){
            if(result>=46340){
                System.out.println(result);
                System.out.println(result*result);
            }

        }
        return result-1;
    }

    public static void main(String[] args) {
        System.out.println(10>>2);
        System.out.println(46341*46341);
    }
}
