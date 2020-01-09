package arc;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int start = 1;
    private volatile boolean flag1 = false;
    private volatile boolean flag2 = false;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(;;){
            while (flag1){
                Thread.yield();
            }
            if (start>n) {
                System.exit(0);
            }
            printNumber.accept(0);
            flag1=!flag1;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(;;start++){
            while (!flag2){
                Thread.yield();
            }
            while (!flag1){
                Thread.yield();
            }
            if (start>n) {
                System.exit(0);
            }
            printNumber.accept(start);
            flag1 = !flag1;
            flag2 = !flag2;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(;;start++){
            while (flag2){
                Thread.yield();
            }
            while (!flag1){
                Thread.yield();
            }
            if (start>n) {
                System.exit(0);
            }
            printNumber.accept(start);
            flag1 = !flag1;
            flag2 = !flag2;
        }

    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        new Thread(){
            @Override
            public void run(){
                try {
                    zeroEvenOdd.even(x-> System.out.println(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                try {
                    zeroEvenOdd.odd(x-> System.out.println(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                try {
                    zeroEvenOdd.zero(x-> System.out.println(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}