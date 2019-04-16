package arc;

import java.util.LinkedList;
import java.util.List;

public class W131_5018 {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new LinkedList<>();
        for (int i = 0; i < queries.length; i++) {
            result.add(work(queries[i], pattern));
        }
        return result;
    }

    public static boolean work(String query, String pattern) {
        char[] queryChars = query.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int i = 0, j = 0;
        for (; i < queryChars.length; ) {
            if (j<patternChars.length&&queryChars[i] == patternChars[j]) {
                i++;
                if(j<patternChars.length){
                    j++;
                }
            } else if (queryChars[i] <= 90) {
                return false;
            } else {
                i++;
            }
        }
        if (j == patternChars.length) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(camelMatch(new String []{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa"));
    }
}
