package arc;

public class Q525 {
    public static int findMaxLength(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp--;
            } else {
                temp++;
            }
        }
        if(temp == 0) return nums.length;
        int a = Math.abs(temp), left = 0, right = 0, i = 0, j = nums.length -1;
        for (; i < nums.length; i++) {
            if(left == a)break;
            if(temp>0){
                if(nums[i]==1)
                    left++;
                else
                    left--;
            }else {
                if(nums[i]==1)
                    left--;
                else
                    left++;
            }
        }

        for (; j >= 0; j--) {
            if(right == a)break;
            if(temp>0){
                if(nums[j]==1)
                    right++;
                else
                    right--;
            }else {
                if(nums[j]==1)
                    right--;
                else
                    right++;
            }
        }
        if (i>(nums.length-1-j))
            return j+1;
        else
            return nums.length-i;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));
    }
}
