package arc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Q30 {
    static class MapNode {
        char value;
        Map <Character, MapNode> nextNodeMaps;

        public MapNode(char value) {
            this.value = value;
        }
    }

    public static List <Integer> findSubstring(String s, String[] words) {
        Map <Character, MapNode> startCharRecord = new HashMap <>();
        List <MapNode> endCharRecord = new LinkedList <>();
        int wordsTotalLength = printMap(words, startCharRecord, endCharRecord);
        char[] chars = s.toCharArray();
        List<Integer> result = new LinkedList <>();
        for(int i=0;i<chars.length - wordsTotalLength;){
            if (startCharRecord.get(chars[i])!=null){
                for(int j=i;j<i+wordsTotalLength;j++){
                    List <MapNode> temp = (List <MapNode>) ((LinkedList<MapNode>) endCharRecord).clone();
                    MapNode t = startCharRecord.get(chars[i]);
//                    do {
//                        if(t.nextNodeMaps!=null){
//                            if(t.nextNodeMaps.get(chars[j])!=null)
//
//                        }
//                    }
                }
            }else {
                i++;
            }
        }
        return null;
    }

    public static int printMap(String[] words, Map <Character, MapNode> startCharRecord, List <MapNode> endCharRecord) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            char[] wordChar = words[i].toCharArray();
            result = words.length*wordChar.length;
            if (startCharRecord.get(wordChar[0]) == null)
                startCharRecord.put(wordChar[0], new MapNode(wordChar[0]));
            MapNode mapNode = startCharRecord.get(wordChar[0]);
            for (int j = 1; j < wordChar.length; j++) {
                MapNode mapNode1 = new MapNode(wordChar[j]);
                if (mapNode.nextNodeMaps == null) {
                    HashMap <Character, MapNode> mapNodeHashMap = new HashMap <>();
                    mapNodeHashMap.put(wordChar[j], mapNode1);
                    mapNode.nextNodeMaps = mapNodeHashMap;
                } else if (mapNode.nextNodeMaps.get(wordChar[j]) == null) {
                    mapNode.nextNodeMaps.put(wordChar[i], mapNode1);
                }
                if (j < wordChar.length - 1)
                    mapNode = mapNode1;
                else
                    endCharRecord.add(mapNode1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] strings = {"adfg","acfs","dcfh","qwertg"};
        Map <Character, MapNode> startCharRecord = new HashMap <>();
        List <MapNode> endCharRecord = new LinkedList <>();
        printMap(strings, startCharRecord, endCharRecord);
        int a = 3;
    }
}
