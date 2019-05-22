package testForReactive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

public class TestForFlow {
    public static void main(String[] args) {
        Flow.Publisher<String> publisher = subscriber -> {
            System.out.println("zero");
            subscriber.onNext("1111");
            System.out.println("one");
            subscriber.onNext("2222");
            System.out.println("two");
            subscriber.onError(new Exception("error"));
        };
        publisher.subscribe(new Flow.Subscriber<String>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
            }

            @Override
            public void onNext(String item) {
                System.out.println(item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
        publisher.subscribe(new Flow.Subscriber<String>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
            }

            @Override
            public void onNext(String item) {
                System.out.println(item + "**********");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage() + "**********");
            }

            @Override
            public void onComplete() {

            }
        });
        List result = new ArrayList(){};
        new LinkedList<Integer>(){{
            for(int i=0;i<100000;i++) add(i);
        }}.parallelStream().forEach(a->{
            if(a%2==0)
            result.add(a);
        });
        int b=0;
        new LinkedList<>().stream().map(a->{return 0;});
    }
}
