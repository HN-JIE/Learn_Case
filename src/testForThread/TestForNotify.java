package testForThread;

public class TestForNotify {
    public synchronized void class1(){
        try {
            System.out.println("class1");
            wait(100000);
            System.out.println("class1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void class2(){
        try {
            System.out.println("class2");
            wait();
            System.out.println("class2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void class3(){
        try {
            System.out.println("class3");
            wait();
            System.out.println("class3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void class4(){
        try {
            System.out.println("class4");
            wait();
            System.out.println("class4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void class5(){
        try {
            System.out.println("class5");
            wait();
            System.out.println("class5");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void myNotify(){
        notify();
    }
    public synchronized void myNotifyAll(){
        notifyAll();
    }

    public static void main(String[] args) {
        TestForNotify testForNotify = new TestForNotify();
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                testForNotify.class1();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                testForNotify.class2();
            }
        };
        Thread thread3 = new Thread(){
            @Override
            public void run(){
                testForNotify.class3();
            }
        };
        Thread thread4 = new Thread(){
            @Override
            public void run(){
                testForNotify.class4();
            }
        };
        Thread thread5 = new Thread(){
            @Override
            public void run(){
                testForNotify.class5();
            }
        };
        Thread thread6 = new Thread(){
            @Override
            public void run(){
                testForNotify.myNotify();
            }
        };
        Thread thread7 = new Thread(){
            @Override
            public void run(){
                testForNotify.myNotifyAll();
            }
        };
        thread3.start();
        thread1.start();
        thread2.start();
//        thread3.start();
        thread4.start();
        thread5.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread6.start();
        thread7.start();
    }
}
