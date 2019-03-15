package arc;

public class Q991 {
    public static void main(String[] args) {
        for (int i= 1;i<=10;i++)
        System.out.println(get(i));
    }
    public static int brokenCalc(int X, int Y) {
        int num1 = 0;
        int x= X;
        for(;x<Y;num1++){
            x=x+X;
        }
        int lefted = Y + X -x;
        if(lefted>0)
            return num1+get(lefted);
        else
            return num1;
    }

    public static int get(int target){
        if (target == 1 ){
            return 1;
        }
        int result = 0;
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0; (target|(1<<i)) != target ;i++){
            result++;
        }
        if(target == 1<<result)
            return result;
        target = target / (1<<result);
        int i = 0;
        for(; (1<<i)<=target; i++){
            if((target%(1<<(i+1))) >= 1<<i ){
                temp1 = temp1 + i +1;
            }else {
                temp2 = temp2 + (1<<i);
            }
        }
        if(temp2 == 0){
            return result + Math.min(temp1 -1,i+1);
        }
        return result + Math.min(temp1 -1,i+2+get(temp2));
    }
}
