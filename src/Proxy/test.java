package Proxy;

import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OInt a = new ProxyTestObject();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(a);
        OInt b = (OInt) Proxy.newProxyInstance(a.getClass().getClassLoader(), a.getClass().getInterfaces(), myInvocationHandler);
        b.sayHello();
        b.sayWord("ddede");
    }
}
