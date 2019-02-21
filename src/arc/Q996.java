package arc;

public class Q996 {
    public static void main(String[] args) {
        A a = new A();
        work(a);
        System.out.println(a.getA());
    }

    static class A{
        private int a;
        private int b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    public static void work(A a){
        a.setA(12);
    }
}
