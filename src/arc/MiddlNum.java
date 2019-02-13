package arc;

import java.util.*;

public class MiddlNum {
    public static void main(String[] args) {
        int[] num = {1,4,2,3};
        double[] a= medianSlidingWindow(num,4);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        Map<Integer,Integer> positionMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            positionMap.put(i,i);
        }
        int[] sortNum = sort(nums.clone(),0,nums.length-1,positionMap);
        double []result = new double[nums.length-k+1];
        LinkedList list  = new LinkedList();
        for(int i=0;i<sortNum.length;i++){
            list.add(sortNum[i]);
        }
        for(int i=0;i<nums.length-k+1;i++){
            LinkedList temList = (LinkedList) list.clone();
            for(int j=0,a=0;j<list.size();j++){
                if(positionMap.get(j)<i||positionMap.get(j)>=k+i){
                    temList.remove(a);
                }else {
                    a++;
                }
            }
            if(k%2==0){
                result[i] = (Double.valueOf(temList.get(k/2).toString())+Double.valueOf(temList.get(k/2-1).toString()))/2;
            }else {
                result[i] = Double.valueOf(temList.get((k-1)/2).toString());
            }
        }

        return result;
    }
    public static int[] sort(int[] nums, int start, int end, Map map) {
        int originStartPosition = (int) map.get(start);
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
                    map.put(temStart,map.get(temEnd));
                    temStart++;
                    break;
                }
                temEnd--;
            } while (temStart < temEnd);
            if (temEnd <= temStart) break;
            do {
                if (nums[temStart] > flag) {
                    nums[temEnd] = nums[temStart];
                    map.put(temEnd,map.get(temStart));
                    temEnd--;
                    break;
                }
                temStart++;
            } while (temEnd > temStart);
        } while (temStart < temEnd);
        nums[temStart] = flag;
        map.put(temStart,originStartPosition);
        if (temStart - start > 0) {
            sort(nums, start, temStart-1,map);
        }
        if (end - temEnd > 1) {
            sort(nums, temEnd + 1, end,map);
        }
        return nums;
    }
}
