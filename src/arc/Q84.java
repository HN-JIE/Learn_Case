package arc;

import java.util.Stack;

public class Q84 {
    public static int largestRectangleArea(int[] heights) {
        if (heights.length==0)return 0;
        if (heights.length==1)return heights[0];
        Stack<Integer> stack = new Stack();
        int flag = 0;
        int result = heights[flag];
        stack.push(flag);
        while (++flag<heights.length){
            if(heights[flag-1]<=heights[flag]){
                result = Math.max(heights[flag], result);
            } else {
                do {
                    if(!stack.isEmpty()){
                        int temp = stack.pop();
                        if(heights[temp]>=heights[flag]){
                            result = Math.max(Math.max(result, (flag-temp+1)*heights[flag]),heights[temp]*(flag-temp));
                            continue;
                        }
                        stack.push(temp);
                    }else {
                        result = Math.max(result, (flag+1)*heights[flag]);
                    }
                    break;
                }while (true);
            }
            stack.push(flag);
        }
        if (!stack.isEmpty()){
            int latest = stack.pop();
            result = Math.max(heights[latest], result);
            while (!stack.isEmpty()){
                int temp = stack.pop();
                result = Math.max(heights[temp]*(latest-temp+1), result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,2}));
    }
}
