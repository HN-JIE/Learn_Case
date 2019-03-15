package testForCollection;

public class TestForTreeMap {
    public static void main(String[] args) {
        A a = getB();
        System.out.println(a.getA());
    }
    public static B getB(){
        B b = new B();
        b.setA(1);
        b.setB(2);
        return b;
    }
    static class A {
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
    static class B extends A{
        private int b;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
