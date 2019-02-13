//package arc;
//
//public class SumOfTwo {
//    public static void main(String[] args) {
//        int[] a = new int[]{2,5,5,11};
//        int[] c = sum(a, 10);
//        int d = 0;
//    }
//
//    public static int[] sum(int[] nums, int target) {
//        int[] result = new int[]{0,nums.length-1};
//        if(nums.length<=2)return result;
//        int[] sortNums = sort(nums.clone(),0,nums.length-1);
//        int temResult = sortNums[result[0]]+sortNums[result[1]]-target;
//        for (int i=0,j=sortNums.length-1;i<=j;){
//            if(temResult==0){
//                return result;
//            }else if(temResult<0){
//                if(sortNums[i+1]+sortNums[j]-target<0){
//                    i++;
//                    result[0]=i;
//                    temResult = sortNums[result[0]]+sortNums[result[1]]-target;
//                }else if(sortNums[i+1]+sortNums[j]-target==0){
//                    result[0]=i+1;
//                    temResult = sortNums[result[0]]+sortNums[result[1]]-target;
//                }else {
//
//                }
//            }
//        }
//        return result;
//    }
//
//    private static int[] sort(int[] nums, int start, int end) {
//        int temStart = start;
//        int temEnd = end;
//        int flag = nums[temStart];
//        if (nums.length < 2) {
//            return nums;
//        }
//        do {
//            do {
//                if (nums[temEnd] < flag) {
//                    nums[temStart] = nums[temEnd];
//                    temStart++;
//                    break;
//                }
//                temEnd--;
//            } while (temStart < temEnd);
//            if (temEnd <= temStart) break;
//            do {
//                if (nums[temStart] > flag) {
//                    nums[temEnd] = nums[temStart];
//                    temEnd--;
//                    break;
//                }
//                temStart++;
//            } while (temEnd > temStart);
//        } while (temStart < temEnd);
//        nums[temStart] = flag;
//        if (temStart - start > 0) {
//            sort(nums, start, temStart);
//        }
//        if (end - temEnd > 1) {
//            sort(nums, temEnd + 1, end);
//        }
//        return nums;
//    }
//}
