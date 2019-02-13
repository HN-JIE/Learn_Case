package testForThread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestForCAS {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(0);
        int b = a.addAndGet(3);

        for(int i=0;i<1000;i++){
            new Thread(){
                @Override
                public void run() {
                    a.incrementAndGet();
                }
            }.start();
        }
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
}
