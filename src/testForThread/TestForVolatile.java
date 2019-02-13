package testForThread;

public class TestForVolatile {
    public static int num;
    public static int count = 0;
    public static void main(String[] args) {
        for (;count<1000;count++){
            new Thread(){
                @Override
                public void run(){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    num++;
                }
            }.start();
        }
        System.out.println(count);
    }
}
