package arc;

import java.util.LinkedList;
import java.util.List;

public class Q866 {

    public static List<Long> a = new LinkedList();

//    public static int primePalindrome(int n) {
//        int ss = 1;
//        if(n==1)
//            return 2;
//        if(n==2)
//            return 2;
//        if(n==3)
//            return 3;
//        for (int i = n; ; i++) {
//            if ((i%6==5||i%6==1)&&isPalindrome(i)) {
//                get(a, i);
//                boolean tem1 = true;
//                for (int j = 0; j < a.size(); j++) {
//                    if(i<=a.get(j)) break;
//                    if (i % a.get(j) == 0) {
//                        tem1 = false;
//                        break;
//                    }
//                }
//                if (tem1) {
//                    return i;
//                }
//            }
//        }
//    }
//
//    public static boolean isPalindrome(int x) {
//        char[] a = String.valueOf(x).toCharArray();
//        for (int i = 0, j = a.length - 1; j > i; i++, j--) {
//            if (a[i] != a[j]) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void get(List<Long> a, Long target) {
        for (Long i = a.size() > 0 ? a.get(a.size() - 1) : 2l; i < target / 2; i++) {
            boolean tem = true;
            for (int j = 0; j < a.size(); j++) {
                if (i % a.get(j) == 0) {
                    tem = false;
                    break;
                }
            }
            if (tem) {
                a.add(i);
            }
        }
    }


    public static void main(String[] args) {
        get(a, 59933l);
        List<Long> result = new LinkedList<>();
        a.parallelStream().forEach(c->{
            if(7140229933l%c==0){
                result.add(c);
            }
        });
        result.add(7140229933l%result.get(0));
    }
}
