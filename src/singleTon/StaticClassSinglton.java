package singleTon;

public class StaticClassSinglton {
    private StaticClassSinglton(){

    }
    static class Innr{
        private static final StaticClassSinglton staticClassSinglton = new StaticClassSinglton();
    }

    public static StaticClassSinglton getStaticClassSinglton() {
        return Innr.staticClassSinglton;
    }
}
