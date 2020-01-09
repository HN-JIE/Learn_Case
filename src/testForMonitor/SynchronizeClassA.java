package testForMonitor;

 class SynchronizeClassA {
    public synchronized void print(int i){
        System.out.println(i+"___start!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
