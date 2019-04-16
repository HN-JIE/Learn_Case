package arc;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public Map<String,Integer> map ;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for(Map.Entry entry: map.entrySet()){
            if(entry.getKey().toString().startsWith(prefix)){
                sum=sum+(int)entry.getValue();
            }
        }
        return sum;
    }
}
