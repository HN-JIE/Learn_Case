package testForThread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SelfThread extends Thread {
    private ReentrantReadWriteLock reentrantReadWriteLock;
    private int num;

    public SelfThread(ReentrantReadWriteLock reentrantReadWriteLock, int num) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
        this.num = num;
    }

    @Override
    public void run() {
        reentrantReadWriteLock.writeLock().lock();
//        reentrantReadWriteLock.readLock().lock();
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("thread" + this.num);
//        System.out.println(Thread.currentThread().getId());
//        reentrantReadWriteLock.readLock().unlock();
        reentrantReadWriteLock.writeLock().unlock();
    }
}
