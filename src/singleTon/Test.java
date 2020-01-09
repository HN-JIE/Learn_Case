package singleTon;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) {
        Class a = StaticClassSinglton.class;
        Constructor[]c = a.getDeclaredConstructors();
        AccessibleObject.setAccessible(c, true);
        for(Constructor cc:c){
            try {
                StaticClassSinglton s = (StaticClassSinglton) cc.newInstance();
                System.out.println("hhh");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
