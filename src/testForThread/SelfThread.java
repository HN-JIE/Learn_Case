package testForThread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SelfThread extends Thread {
    private ReentrantReadWriteLock reentrantReadWriteLock;
    public SelfThread(ReentrantReadWriteLock reentrantReadWriteLock){
        this.reentrantReadWriteLock=reentrantReadWriteLock;
    }
    @Override
    public void run(){
        reentrantReadWriteLock.writeLock().lock();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
        reentrantReadWriteLock.writeLock().unlock();
    }
}
