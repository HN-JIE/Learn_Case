package arc;

public class NoContinuousNums {
    public static void main(String[] args) {
        System.out.println(8+":"+findIntegers1(8));
        System.out.println(4+":"+findIntegers1(4));
        System.out.println(2+":"+findIntegers1(2));

        System.out.println(System.currentTimeMillis());
        System.out.println(1000000000+":"+findIntegers1(1000000000));
        System.out.println(System.currentTimeMillis());

    }
    public static int findIntegers1(int num) {
        if(num==0){
            return 1;
        }
        int result=1;
        for(int i =1;i<=num;i++){
            result = result+(check(i)?1:0);
        }
        return result;
    }
    public static Boolean check(int num){
        String numString = Integer.toBinaryString(num);
        if(numString.indexOf("11")>=0){
            return false;
        }else{
            return true;
        }
    }

    public static int get(int num){
        int n=0;
        for(;Math.pow(2,n)<=num;n++);
        return n;
    }

    public static int get1(int num){
        if(num==0){
            return 2;
        }else if(num==1){
            return 3;
        }else{
            return get1(num-1)+get1(num-2)-1;
        }
    }
    public static int findIntegers(int num){
        if(num==0){
            return 1;
        }else if(num==1){
            return 2;
        }else if(num==2){
            return 3;
        }else if(num==3){
            return 3;
        }
        int count = get(num)-1;
        int temp= (int) Math.pow(2,count);
        if(num-temp<temp/2){
                return get1(count)-1+findIntegers(num%(temp/2));
        }else {
                return get1(count)-1+get1(count-1)-1;
        }
    }
}
