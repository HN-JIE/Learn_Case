package arc;

import java.util.*;

public class eightNineEight {
    public static void main(String[] args) {
        System.out.println(subarrayBitwiseORs(new int[]{1,1,2}));
    }
    public static int subarrayBitwiseORs(int[] A) {
        int result = 0;
        Map map = new HashMap();
        List<Integer> list= new LinkedList();
        List<Integer> list1 = new LinkedList<>();
        for(int i=0;i<A.length;i++){
            if(map.get(A[i])==null){
                map.put(A[i],A[i]);
                result++;
            }
            list.add(A[i]);
        }
        for(int i=2;i<=A.length;i++){
            for(int x:list){
                list1.add(x);
            }
            list.clear();
            for(int j=i-1;j<A.length;j++){
                int num;
                num =list1.get(j+1-i)|A[j];
                list.add(num);
                if(map.get(num)==null){
                    map.put(num,num);
                    result++;
                }
            }
            list1.clear();
        }
        return result;
    }
}

