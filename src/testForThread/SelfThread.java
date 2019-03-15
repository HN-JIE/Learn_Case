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
        reentrantReadWriteLock.readLock().lock();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
        reentrantReadWriteLock.readLock().unlock();
        reentrantReadWriteLock.writeLock().unlock();
    }
}
