package arc;

public class Q962 {
    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{8,1,6,9,2,3,5,4,5}));
    }
    public static int maxWidthRamp(int[] A) {
        int result = 0;
        int temp = A.length-1;
        for (int i =0;i<temp;){
            for(int j=A.length-1;j>i;j--){
                if(A[i]<=A[j]&&j-i>result){
                    result=j-i;
                    temp = A.length-result;
                }
            }
            int count =1;
            for(;count+i<A.length-1&&A[i]<A[count+i];count++){}
            i=count+i;
        }
        return result;
    }
}
