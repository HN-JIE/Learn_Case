package arc;

import java.util.HashMap;
import java.util.Map;

public class Three {
    public static void main(String[] args) {
        lengthOfLongestSubstring1("abcabcbb");
    }
    public static int lengthOfLongestSubstring(String s) {
        byte[] bytes =s.getBytes();
        int result=getNum(bytes,0,s.length()-1,0);
        System.out.println(s+":"+result);
        return result;
    }
    public static int getNum(byte[]bytes,int start ,int end,int result){
        Map<Byte,Integer> map = new HashMap();
        for(int i=start;i<=end;){
            if(map.get(bytes[i])==null){
                map.put(bytes[i],i);
                i++;
            }else {
                return getNum(bytes,map.get(bytes[i])+1,end,result>i-start?result:i-start);
            }
        }
        return end-start+1>result?end-start+1:result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
