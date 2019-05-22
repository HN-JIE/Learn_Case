package arc;

public class Q397 {
    public static int integerReplacement(int n) {
        if(n==1)
            return 0;
        if (n==Integer.MAX_VALUE)
            return 32;
        return work(n);
    }
    public static int work(int n){
        int temp =1;
        if(n==2){
            return temp;
        }
        for(;n%2==0;){
            n=n/2;temp++;
            if(n==2){
                return temp;
            }
        }
        if(judge(n).equals("add"))
            return work(n+1)+temp;
        else
            return work(n-1)+temp;
    }

    public static String judge(int target){
        int flag=0;
        if(target==3)return  "slice";
        for(;Math.pow(2,flag)<=target;flag++);
        int addNum = target+1;
        if(addNum==Math.pow(2,flag+1)&&addNum>4){
            return "add";
        }
        int sliceNum = target-1;
        int temp1 =0,temp2=0;
        for(;flag>=0;flag--){
            int a = 2<<flag;
            if(addNum%(a*2)>=a){
                temp1++;
            }
            if(sliceNum%(a*2)>=a){
                temp2++;
            }
        }
        if(temp1>temp2){
            return "slice";
        }else {
            return "add";
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(integerReplacement(2147483647));
    }
}
