package testForSingleton;

public class TestForSingleton {
    private static volatile TestForSingleton testForSingleton;

    public TestForSingleton getInstance(){
        if (this.testForSingleton == null){
            synchronized (this){
                if(this.testForSingleton == null){
                    testForSingleton = new TestForSingleton();
                }
            }
        }
            return this.testForSingleton;
    }

    public static void main(String[] args) {
        String s =null;
        String st ="?"+s;
        System.out.println(st);
    }
}
