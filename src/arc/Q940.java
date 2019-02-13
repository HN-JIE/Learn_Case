package arc;

import java.util.*;

public class Q940 {
    public static void main(String[] args) {
        System.out.println(distinctSubseqII("abc"));
    }
    public static int distinctSubseqII(String s) {
        int result = 0;
        Map<Character,List> hash = new HashMap();
        Map<Character,Integer> resultMap = new HashMap();
        char[] sChar = s.toCharArray();
        for(int i=0;i<sChar.length;i++){
            if(resultMap.get(sChar[i])!=null){
                if(hash.get(sChar[i])==null){
                    List<Integer> position = new LinkedList<>();
                    position.add(resultMap.get(sChar[i]));
                    position.add(i);
                    hash.put(sChar[i],position);
                } else {
                    hash.get(sChar[i]).add(i);
                }
            }
        }
        for(List<Integer>list:hash.values()){

        }
        return 0;
    }
    public static int getA(int n){
        int result=1;
        for(;n>0;n--){
            result=result*n;
        }
        return result;
    }

    public static int getC(int n,int m){
        int result =1;
        return result;
    }
}
