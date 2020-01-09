package Proxy;

public class ProxyTestObject implements OInt{
    @Override
    public void sayHello(){
        System.out.println("hello");
    }
    @Override
    public String  getHello(){
        return "hello";
    }
    @Override
    public void sayWord(String word){
        System.out.println(word);
    }
}
