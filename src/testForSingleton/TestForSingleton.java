package testForSingleton;

import java.util.LinkedList;
import java.util.List;

public class TestForSingleton {
    private static volatile TestForSingleton testForSingleton;

    private static volatile int[] a = new int[10];
    private static int[] b = new int[10];
    private static int i = 0;

    public TestForSingleton getInstance(){
        if (this.testForSingleton == null){
            synchronized (this){
                if(this.testForSingleton == null){
                    testForSingleton = new TestForSingleton();
                }
            }
        }
            return this.testForSingleton;
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a[0] = 1;
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                do {
                    if(a[0]==1){
                        System.out.println(a[0]);
                        return;
                    }
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }while (true);
            }
        }.start();
//        System.out.println(a.size());
//        System.out.println(b.size());
    }
}
