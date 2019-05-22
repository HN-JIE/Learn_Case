package testForThread;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;

public class TestForHandle {
    static class Demo {
        protected String stringTest;
        protected int intTest;
        public void setStringTest(String stringTest){
            this.stringTest=stringTest;
        }

        public int getIntTest() {
            return intTest;
        }

        public void setIntTest(int intTest) {
            this.intTest = intTest;
        }

        public String getStringTest() {
            return stringTest;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(System.currentTimeMillis());
            Demo demo1 = new Demo();
            MethodHandles.Lookup l = MethodHandles.lookup();
            VarHandle STRINGTEST = l.findVarHandle(Demo.class, "stringTest", String.class);
            VarHandle INTTEST = l.findVarHandle(Demo.class, "intTest", int.class);
            for (int i = 0; i < 1000; i++) {
                STRINGTEST.set(demo1, "哈哈" + i);
                INTTEST.set(demo1, i);
                System.out.print(STRINGTEST.get(demo1));
                System.out.print(INTTEST.get(demo1));
            }
            System.out.println();
            System.out.println(System.currentTimeMillis());
            Demo demo2 = new Demo();
            Field stringField = Demo.class.getDeclaredField("stringTest");
            Field intField = Demo.class.getDeclaredField("intTest");
            for (int i = 0; i < 1000; i++) {
                stringField.set(demo2, "哈哈" + i);
                intField.set(demo2, i);
                System.out.print(stringField.get(demo2));
                System.out.print(intField.get(demo2));
            }
            System.out.println();
            System.out.println(System.currentTimeMillis());

            Demo demo3 = new Demo();
            for(int i=0;i<1000;i++){
                demo3.setIntTest(i);
                demo3.setStringTest("哈哈"+i);
                System.out.print(demo3.getStringTest());
                System.out.print(demo3.getIntTest());
            }
            System.out.println();
            System.out.println(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
