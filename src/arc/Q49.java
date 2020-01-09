package arc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q49 {
    public static Map<Character, Long> data = new HashMap();
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new LinkedList <>();
        if(strs.length == 1) return new LinkedList <>(){{add(new LinkedList <>(){{add(strs[0]);}});}};
        Map<Long, List> resultMap = new HashMap <>();
        for(int i = 0;i<strs.length;i++){
            char[] strChars = strs[i].toCharArray();
            long key = 0l;
            for(int j = 0;j<strChars.length;j++){
                key = key*data.get(strChars[j]);
            }
            if(resultMap.get(key) == null){
                List list = new LinkedList();
                list.add(strs[i]);
            }else {
                resultMap.get(key).add(strs[i]);
            }
        }
        List result = new LinkedList();
        for(Map.Entry<Long, List> entry:resultMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt(""));
    }
}
