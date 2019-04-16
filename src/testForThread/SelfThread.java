package testForThread;

import java.util.LinkedList;
import java.util.List;
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

    public static void main(String[] args) {
        List a = new LinkedList();
        a.add(1);
        List b = new LinkedList<>(a);
        C c = new C();
        c.c=a;
        a.add(2);
        int dd =1;
    }

    static class C{
        List c;
    }
}
