package arc;

import java.util.*;

class MaxStack {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return - (Integer) o1 + (Integer)o2;
            }
        });
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        while (queue.size()>0){
            System.out.println(queue.poll());
        }
    }
}
