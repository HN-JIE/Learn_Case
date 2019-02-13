package arc;

public class Q902 {
    public static void main(String[] args) {
//        String[]nums = {"7"};
//        int n = 5;
//        System.out.println((++n)+(++n)+(++n));
        int i = 5, j = 5, k = 5;
        int a, b, c;
        a = ++i;
        b = (++j) + (++j) + (++j);
        c = (++k) + (++k) + (++k);
        System.out.println(a+"  "+b+"  "+c);
    }
    public static int atMostNGivenDigitSet(String[] D, int N) {
        int a=0;
        int result;
        int count=0;
        if(N==0)return 0;
        for(;Math.pow(10,a+1)<=N;a++);
        for(int i=0;i<D.length;i++){
            if(N/Math.pow(10,a)>=Integer.valueOf(D[i])+1){
                count++;
            }else {
                break;
            }
        }
        if(a==0)
            return count==D.length?count:count+(N==Integer.valueOf(D[count])?1:0);
        if(D.length==count)
            return count*get1(a,D.length);
        if(N/Math.pow(10,a)==Integer.valueOf(D[count]))
            result=(count+1)*get1(a,D.length)+atMostNGivenDigitSet(D, (int) (N%(Math.pow(10,a)*Integer.valueOf(D[count]))));
        else {
            result=(count+1)*get1(a,D.length);
        }
        return result;
    }

    public static int get1(int weishu,int nums){
        if(weishu==1) return nums;
        else {
            return (int) (Math.pow(nums,weishu)+get1(weishu-1,nums));
        }
    }
}
