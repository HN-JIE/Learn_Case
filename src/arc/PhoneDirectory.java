package arc;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;

public class PhoneDirectory {

    public volatile int maxNumbers;

    public BitSet data;

    public AtomicInteger used;


    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        this.used = new AtomicInteger(0);
        data = new BitSet(maxNumbers);
    }

    public int get() {
        while (used.get()<maxNumbers){
            for(int i=0;i<maxNumbers;i++){
                if (!data.get(i)){
                    synchronized (this){
                        if (!data.get(i)){
                            data.set(i);
                            used.incrementAndGet();
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public boolean check(int number) {
        return !data.get(number);
    }

    public void release(int number) {
        data.set(number-1, false);
    }
}
