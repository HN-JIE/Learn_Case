package arc;

public class JudgePoint24 {
    public static void main(String[] args) {

    }

    public static boolean judgePoint24(int[] nums) {
        int target = 24;
        int[] sortNum = sort(nums.clone(), 0, nums.length - 1);
        return check(sortNum,0,sortNum.length-1,target);
    }

    public static boolean check(int[]num,int start,int end,double target){
        if(check(num,start,end-1,target-num[end])||check(num,start,end-1,target/num[end]))
            return true;

        return false;
    }

    private static int[] sort(int[] nums, int start, int end) {
        int temStart = start;
        int temEnd = end;
        int flag = nums[temStart];
        if (nums.length < 2) {
            return nums;
        }
        do {
            do {
                if (nums[temEnd] < flag) {
                    nums[temStart] = nums[temEnd];
                    temStart++;
                    break;
                }
                temEnd--;
            } while (temStart < temEnd);
            if (temEnd <= temStart) break;
            do {
                if (nums[temStart] > flag) {
                    nums[temEnd] = nums[temStart];
                    temEnd--;
                    break;
                }
                temStart++;
            } while (temEnd > temStart);
        } while (temStart < temEnd);
        nums[temStart] = flag;
        if (temStart - start > 0) {
            sort(nums, start, temStart);
        }
        if (end - temEnd > 1) {
            sort(nums, temEnd + 1, end);
        }
        return nums;
    }
}
