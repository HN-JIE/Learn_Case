package testForThread;

import java.util.concurrent.*;

public class TestForCallable {
    static class CallableDemo implements Callable{

        @Override
        public String call() throws Exception {
            System.out.println(System.currentTimeMillis());
            return "测试结束";
        }
    }

    public static void main(String[] args) {
        CallableDemo demo = new CallableDemo();
        FutureTask<String> futureTask = new FutureTask<>(demo);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
