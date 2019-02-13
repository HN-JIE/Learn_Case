package testForThread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestForThreadPoolExecutor {
    public static int num = 1;
    private static class MyThread extends Thread{
        private int threadNum;
        public MyThread(int num){
            this.threadNum = num;
        }
        @Override
        public void run(){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            threadNum++;
            System.out.println(threadNum);
        }
    }
    public static void main(String[] args) {
        ThreadPoolExecutor a =new ThreadPoolExecutor(10,
                20,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());

        for(int i=0;i<100;i++){
            MyThread myThread = new MyThread(i);
            a.execute(myThread);
        }
    }
}
