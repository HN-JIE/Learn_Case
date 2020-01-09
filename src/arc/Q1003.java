package arc;

import java.util.Date;

public class Q1003 {
    public static boolean isValid(String S) {
        char[] chars = S.toCharArray();
        char[] temp = new char[]{'a', 'b', 'c'};
        if (chars.length % 3 != 0 || chars.length == 0) return false;
        int start = 0, end = chars.length - 1;
        for (; start < end; ) {
            if ('a' != chars[start]) return false;
            do {
                if(end-start>3&&chars[end]=='c'&&chars[end-1]=='b'&&chars[end-2]=='a')
                    end = end-3;
                else
                    break;
            }while (true);
            start++;
            boolean flag = false;
            for (int i = 1; i <= 2; i++) {

                if (temp[i] == chars[start]) {
                    flag = true;
                    start++;
                } else if ((flag && temp[i] == chars[end])
                        || ((!flag) &&
                        (temp[i] == chars[(int) (end + Math.pow(-1, i))]))) {
                    end--;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("\"%d\"+\"%s\", 2,\"dwdsadas\"");
        System.out.printf("%d"+"%s", 2,"dwdsadas");
    }
}
