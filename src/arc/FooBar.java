package arc;

import java.util.concurrent.Semaphore;
class FooBar {
    private int n;

    private static boolean flag = true;
    public static Semaphore semaphore = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            semaphore.acquire(flag?1:2);
            printFoo.run();
            flag = false;
            semaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.

            semaphore.acquire(flag?2:1);
            printBar.run();
            flag = true;
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(1);
        new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.foo(new Thread(){
                        @Override
                        public void run(){
                            System.out.println("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                try {
                    fooBar.bar(new Thread(){
                        @Override
                        public void run(){
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}