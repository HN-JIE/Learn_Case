package arc;

import java.util.LinkedList;
import java.util.List;

public class Q557 {
    public static String reverseWords(String s) {
        char[] ss = s.toCharArray();
        List<StringBuffer> sss = new LinkedList<>();
        int j = 0;
        for(int i = ss.length-1;i>=0;i--){
            if(ss[i] == ' '){
                j++;
            }else {
                if(sss.size() <=j){
                    StringBuffer tem = new StringBuffer();
                    tem.append(ss[i]);
                    sss.add(tem);
                } else {
                    sss.get(j).append(ss[i]);
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int a = sss.size()-1; a>0;a--){
            stringBuffer.append(sss.get(a));
            stringBuffer.append(' ');
        }
        if (sss.size()>0){
            stringBuffer.append(sss.get(0));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
