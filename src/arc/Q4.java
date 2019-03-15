package arc;

public class Q4 {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1, 2, 3, 4};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length == 0){
            return b.length%2 ==0?(b[b.length/2]+b[b.length/2-1])/2:b[(b.length-1)/2];
        }
        int lengthA = a.length;
        int lengthB = b.length;
        int lengthT = lengthA+lengthB;
        int i=0,j=0;
        int flag = -1;
        if(lengthT%2 == 0){
            return 0.0d;
        }else {
            for(;(i+j)*2<lengthT-1;){
                if(i<lengthA-1&&a[i]<=b[j]){
                    i++;
                }else {
                    j++;
                }
            }
            return Math.min(a[i],b[j]);
        }
    }
}
