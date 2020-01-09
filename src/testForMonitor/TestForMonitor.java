package testForMonitor;

import java.util.HashMap;
import java.util.Map;

public class TestForMonitor {
    private static int i=0;
    public static void main(String[] args) {
        Map m = new HashMap();
        m.entrySet();
        SynchronizeClassA synchronizeClassA = new SynchronizeClassA();
        for(;i<10;i++){
            int a =i;
            System.out.println(a+":"+System.currentTimeMillis());
            new Thread(){
                @Override
                public void run(){
                    System.out.println(a+":"+System.currentTimeMillis());
                    synchronizeClassA.print(a);
                }
            }.start();
        }
    }

}
