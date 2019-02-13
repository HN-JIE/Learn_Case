package arc;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1, 2, 3, 4, 5};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.00d;
    }
    public static double work(int[] num1,int num1Start, int num1End, int[] num2, int num2Start, int num2End){
        return 0.0;
    }
    public static double getMid(int[] num,int start,int end){
        if((end - start)%2==0)
            return (num[(end+start+1)/2]+num[(end+start-1)/2])/2;
        else
            return num[(end+start)/2];
    }
}
