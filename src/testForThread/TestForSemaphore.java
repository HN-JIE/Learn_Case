package testForThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestForSemaphore {
    public static Semaphore semaphore = new Semaphore(3);
    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static class MyNode{
        MyNode myNode;
        MyNode prev;
    }
    static int i=0;
    public static void main(String[] args) {

        for(int j=0;j<100;j++){
            new Thread(){
                @Override
                public void run(){
                    try {
                        semaphore.acquire();
                        reentrantReadWriteLock.writeLock().lock();
                        int a = i;
                        a++;
                        Thread.sleep(1000);
                        i=a;
                        System.out.println(i);
                        Thread.sleep(3000);
                        reentrantReadWriteLock.writeLock().unlock();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
