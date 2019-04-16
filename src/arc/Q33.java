package arc;

public class Q33 {
    public static int search(int[] nums, int target) {
        if(nums.length<1){
            return -1;
        }
        return work(nums, 0, nums.length - 1, target);
    }

    public static int work(int[] nums, int start, int end, int target) {
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else if (start >= end - 1) {
            return -1;
        } else {
            int temp = (start + end) / 2;
            if(nums[start]>nums[temp]){
                if(target>=nums[temp]&&target<=nums[end]){
                    return work(nums,temp, end, target);
                }else {
                    return work(nums, start, temp, target);
                }
            }else {
                if(target>=nums[start]&&target<=nums[temp]){
                    return work(nums, start, temp, target);
                }else {
                    return work(nums,temp, end, target);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,8,1,2,3}, 8));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
