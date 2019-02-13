package arc;

public class Q5 {
    public static void main(String[] args) {

    }
    public static String longestPalindrome(String s) {
        char []stringChars = s.toCharArray();
        return null;
    }

    public static boolean check(char[] data, int start, int end){
        for(;start<end;start++,end--){
            if (data[start]!=data[end]){
                return false;
            }
        }
        return true;
    }

}
