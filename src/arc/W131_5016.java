package arc;



public class W131_5016 {
    public static String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<chars.length;i++){
            int tempCount = 0;
            for(;i<chars.length;i++){
                if(chars[i] == '('){
                    tempCount++;
                    if(tempCount>1){
                        stringBuffer.append(chars[i]);                    }
                }else {
                    tempCount--;
                    if(tempCount>0){
                        stringBuffer.append(chars[i]);
                    }else {
                        break;
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }
}
