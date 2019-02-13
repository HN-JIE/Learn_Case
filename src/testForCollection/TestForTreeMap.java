package testForCollection;

import java.util.Map;
import java.util.TreeMap;

public class TestForTreeMap {
    public static void main(String[] args) {
        create();
    }

    public static void create(){
        Map treeMap = new TreeMap();
        Map<String,Object> stringTreeMap  = new TreeMap();

        treeMap.put(2,2);
        treeMap.put(3,3);
        treeMap.put(6,6);
        treeMap.put(5,5);
        treeMap.put(7,7);
        treeMap.put(4,4);


        treeMap.get(3);

        stringTreeMap.put("a","a");
        stringTreeMap.put("z","z");
        stringTreeMap.put("y","y");
        stringTreeMap.put("s","s");
        stringTreeMap.put("d","d");
        stringTreeMap.put("h","h");


    }
}
