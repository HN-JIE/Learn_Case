package testForJVM;

public class ExceptionTest {
    public static void main(String[] args) {
        double a=6;
        a=a+Math.pow(2,160);
        System.out.println(a);
    }
}
