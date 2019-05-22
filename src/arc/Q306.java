package arc;

public class Q306 {
    public static boolean isAdditiveNumber(String num) {
        if(num.length()<3)
        return false;
        for(int i=1;i<=(num.length()-1)/2;i++){
            if(work(Integer.parseInt(num.substring(0,i)),i,i , num)){
                return true;
            }
        }
        return false;
    }

    public static boolean work(int num1, int num1Length, int num2StartPosition ,String num){
        for(int i=1;i<=Math.min((num.length()-num2StartPosition)/2, num.length()-num1Length);i++){
            int tem = Math.max(num1Length,i);
            if(num.length()-i-num1Length<tem) return false;
            if(num1+Integer.parseInt(num.substring(num2StartPosition,num2StartPosition+i))==Integer.parseInt(num.substring(num2StartPosition+i,num2StartPosition+i+tem))){
                if(num2StartPosition+i+tem==num.length()) return true;
                return work2(Integer.parseInt(num.substring(num2StartPosition,num2StartPosition+i)),num1+Integer.parseInt(num.substring(num2StartPosition,num2StartPosition+i)),tem,num2StartPosition+i+tem,num);
            }else if(num2StartPosition+i+tem+1<num.length()&&(num1+Integer.parseInt(num.substring(num2StartPosition,num2StartPosition+i))==Integer.parseInt(num.substring(num2StartPosition+i,num2StartPosition+i+tem+1)))){
                if(num2StartPosition+i+tem+1==num.length()) return true;
                return work2(Integer.parseInt(num.substring(num2StartPosition,num2StartPosition+i)),num1+Integer.parseInt(num.substring(num2StartPosition,num2StartPosition+i)),tem+1,num2StartPosition+i+tem+1,num);
            }
        }
        return false;
    }
    public static boolean work2(int num1,int num2,int length,int num3Start, String num){
        if(num3Start+length>num.length()){
            return false;
        }
        if(num1+num2==Integer.parseInt(num.substring(num3Start,num3Start+length))){
            if(num3Start+length==num.length()) return true;
            return work2(num2,num1+num2,length,num3Start+length,num);
        }else if(num3Start+length+1<num.length()&&num1+num2==Integer.parseInt(num.substring(num3Start,num3Start+length+1))){
            if(num3Start+length+1==num.length()) return true;
            return work2(num2,num1+num2,length+1,num3Start+length+1,num);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("0235813"));
        System.out.println(isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber("112357"));
        System.out.println(isAdditiveNumber("199100199"));
        System.out.println(isAdditiveNumber("991100101"));
//        System.out.println("1234567".substring(2,3));
    }
}
