package testForThread;

public class TestForVolatile {
    public static int num;
    public static volatile int[] array1 = new int[]{0};
    public static int[] array2 = new int[]{0};
    public static int count = 0;
    public static void main(String[] args) {
        try {
            for (;count<1000;count++){
                Thread temp = new Thread(){
                    @Override
                    public void run(){
                        for (int i=0;i<1000;i++)
                        {
                            num++;
                            array1[0]++;
                            array2[0]++;
                        }
                    }
                };
                temp.start();
                temp.join();
            }
            System.out.println(num);
            System.out.println(array1[0]);
            System.out.println(array2[0]);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
