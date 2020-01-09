package arc;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

public class FindLowestNum {
    public static void main(String[] args) {
        int[] a = {7,5,4,3,1};
        System.out.println(numRescueBoats(a,10));
    }
    public static int find(int []a){
        for(int i=0;i<a.length;i++){
            if(a[i]<1||a[i]>a.length||a[i]==i+1){

            } else {
                int temp = a[i];
                a[i] = -1;
                do{
                    if(a[temp-1]<1||a[temp-1]>a.length||a[temp-1]==temp){
                        break;
                    }
                }while (true);
            }
        }
        return 1;
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }
}
