package arc;

import java.util.LinkedList;
import java.util.List;

public class W131_5019 {
    public static int videoStitching(int[][] clips, int T) {
        List<int[]> t1 = new LinkedList<>();
        for (int i = 0; i < clips.length; i++) {
            t1.add(clips[i]);
        }
        return work(t1, 0, T, 0);
    }

    public static int work(List<int[]> data, int start, int end, int result) {
        int min = start;
        int max = end;
        int i = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        List<int[]> newData = new LinkedList<>();
        for (; i < data.size(); i++) {
            if (data.get(i)[0] <= start) {
                if (data.get(i)[1] >= end) {
                    return 1;
                } else {
                    if (data.get(i)[1] > min) {
                        flag1 =true;
                        min = data.get(i)[1];
                    }
                }
            }
            else if (data.get(i)[1] >= end) {
                if (data.get(i)[0] < max) {
                    flag2 =true;
                    max = data.get(i)[0];
                }
            }
        }
        if(flag1||flag2){
            if(max<=min){
                return 2;
            }
            for(int[] a: data){
                if(a[1]<=min||a[0]>=max){

                }else {
                    newData.add(a);
                }
            }
            int next = work(newData, min, max, result+2);
            return next==-1?-1:2+next;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(videoStitching(new int[][]{{0,5},{1,6},{2,7},{3,8},{4,9},{5,10},{6,11},{7,12},{8,13},{9,14},{10,15},{11,16},{12,17},{13,18},{14,19},{15,20},{16,21},{17,22},{18,23},{19,24},{20,25},{21,26},{22,27},{23,28},{24,29},{25,30},{26,31},{27,32},{28,33},{29,34},{30,35},{31,36},{32,37},{33,38},{34,39},{35,40},{36,41},{37,42},{38,43},{39,44},{40,45},{41,46},{42,47},{43,48},{44,49},{45,50},{46,51},{47,52},{48,53},{49,54}}, 50));
    }
}
