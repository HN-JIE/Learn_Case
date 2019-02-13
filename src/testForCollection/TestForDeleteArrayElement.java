package testForCollection;

import java.util.ArrayList;
import java.util.List;

public class TestForDeleteArrayElement {
    static int j=0;
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<100;i++) a.add(i);
        for (;j<a.size();j++){
             if(a.get(j)%10==0){
                 a.remove(j);
             }
        }
        for (int j=0;j<a.size();j++) System.out.println(a.get(j));
    }
}
