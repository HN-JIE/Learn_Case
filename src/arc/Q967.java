package arc;

import java.util.LinkedList;
import java.util.List;

public class Q967 {
    public static int[] numsSameConsecDiff(int N, int K) {
        if(N==1) {
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            work(N, K, result, i);
        }
        int[] s = new int[result.size()];
        for (int i=0;i<result.size();i++){
            s[i]=result.get(i);
        }
        return s;
    }

    public static void work(int n, int k, List<Integer> result, int tem) {
        int tmp = tem%10;
        if(n>2){
            if(k==0){
                work(n-1, k, result, tem*10+tmp);
            }else {
                if(tmp+k<10){
                    work(n-1, k, result, tem*10+tmp+k);
                }
                if(tmp-k>=0){
                    work(n-1, k, result, tem*10+tmp-k);
                }
            }
        }else {
            if(k==0){
                result.add(tem*10+tmp);
            }else {
                if(tmp+k<10){
                    result.add(tem*10+tmp+k);
                }
                if(tmp-k>=0){
                    result.add(tem*10+tmp-k);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] result1 = numsSameConsecDiff(3,7);
        int[] result2 = numsSameConsecDiff(2,1);
        int tttt=0;
    }
}
