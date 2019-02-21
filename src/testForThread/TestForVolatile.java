package testForThread;

public class TestForVolatile {
    public static volatile int num;
    public static int count = 0;
    public static void main(String[] args) {
        for (;count<1000;count++){
            new Thread(){
                @Override
                public void run(){
                    for (int i=0;i<10;i++)
                    num++;
                }
            }.start();
        }
        System.out.println(num);
    }
}
