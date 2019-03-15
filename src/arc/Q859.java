package arc;

import java.util.HashMap;
import java.util.Map;

public class Q859 {
    public static boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        if(A.length()<2){
            return false;
        }
        return work(A.toCharArray(),B.toCharArray(),0,A.length()-1);
    }

    public static boolean work(char[]a, char[] b, int start, int end){
        do{
            if(a[start]==b[start]&&a[end]==b[end]){
                if(++start>=--end){
                    return booleanwo2(a);
                }
            }else if(a[start]!=b[start]&&a[end]==b[end]){
                end--;
            }else if(a[start]==b[start]&&a[end]!=b[end]){
                start++;
            }else {
                if(a[start]==b[end]&&a[end]==b[start])
                    return wo1(a,b,++start,--end);
                return false;
            }
        }while (true);
    }

    public static boolean wo1(char[]a, char[] b, int astart, int aend){
        for(;astart<=aend;){
            if(a[astart]!=b[astart]||a[aend]!=b[aend]){
                return false;
            }
            astart++;aend--;
        }
        return true;
    }

    public static boolean booleanwo2(char[]a){
        Map<Character,Object> map = new HashMap();
        for(int i=0;i<=a.length-1;i++){
            if(map.get(a[i]) == null){
                map.put(a[i], a[i]);
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(buddyStrings("",""));
        System.out.println(System.currentTimeMillis());
        System.out.println(buddyStrings("ab","ab"));
        System.out.println(System.currentTimeMillis());
        System.out.println(buddyStrings("aa","aa"));
        System.out.println(System.currentTimeMillis());
        System.out.println(buddyStrings("aaaaaaabc","aaaaaaacb"));
        System.out.println(System.currentTimeMillis());
    }
}
