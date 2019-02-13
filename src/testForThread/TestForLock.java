package testForThread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestForLock {
    static ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();

    static int i = 0;
    static class MyThread implements Runnable{
        @Override
        public void run(){
            System.out.println("thread before lock");
            lock1.writeLock().lock();
            System.out.println("thread after lock");
        }
    }
    public static void main(String[] args) {
        lock1.writeLock().lock();
        System.out.println("main lock");
        for (int j=0;j<100;j++){
            SelfThread selfThread = new SelfThread(lock1);
            selfThread.start();
        }
        lock1.writeLock().unlock();
        System.out.println("main unlock");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
