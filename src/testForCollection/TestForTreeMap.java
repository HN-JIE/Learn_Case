package testForCollection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestForTreeMap {
    public static void main(String[] args) {
        HashMap b = new HashMap(9);
        b.put(1,3);
        b.put(3,4);
        b.put(19, 19);
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
