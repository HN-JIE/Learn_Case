package arc;

import java.util.HashMap;
import java.util.Map;

public class Q982 {
    public static void main(String[] args) {
        int[] a= {0,0,0};
        System.out.println(countTriplets(a));
    }
    public static int countTriplets(int[] A) {
        int num = 0;
        Map<String,Integer> temp1 = new HashMap<>();
        Map<String,Integer> temp2 = new HashMap<>();

        for(int i = 0; i<A.length-1; i++){
            for(int j=i+1; j<A.length; j++){
                if((A[i]&A[j])==0&&A[i]!=A[j]){
                    temp1.put("_"+i+"_"+j+"_",A[i]&A[j]);
                } else {
                    temp2.put("_"+i+"_"+j+"_",A[i]&A[j]);
                }
            }
        }
        num = 6*temp1.entrySet().size();
        for(int a= 0;a<A.length;a++){
            if(A[a]==0){
                num+=temp1.entrySet().size()*6;
            }
            for(String ss:temp2.keySet()){
                if(ss.indexOf("_"+String.valueOf(a)+"_")<0&&(temp2.get(ss)&A[a])==0){
                    num+=3;
                }
            }
        }
        return num;
    }
}
