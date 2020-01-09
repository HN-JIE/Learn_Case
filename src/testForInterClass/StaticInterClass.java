package testForInterClass;

public class StaticInterClass {
    private int num;
    static {
        System.out.println("外部类静态代码块");
    }
    static class StaticClass{
        static {
            System.out.println("内部静态类静态代码块");
        }
    }
    class NomarlClass{
        {
            System.out.println("内部普通类普通代码块");
        }
        public NomarlClass(){
            System.out.println("内部普通类构造函数");
        }
        public void setNum(int num){
            StaticInterClass.this.num = num;
        }
    }

    public static void main(String[] args) {
        StaticInterClass staticInterClass = new StaticInterClass();
    }
}
