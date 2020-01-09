package arc;

import java.util.LinkedList;
import java.util.Queue;

public class Q25 {
    static class ListNode{
       int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(null==head||head.next == null||k<=1) return head;
        ListNode preEnd = new ListNode(-1);
        preEnd.next = head;
        ListNode listNode = preEnd;
        ListNode preResult = preEnd;
        for (ListNode segmentStart;(segmentStart = listNode.next)!=null;){
            preEnd.next = work(segmentStart,k);
            int count = k;
            do {
                if (listNode.next==null)break;
                listNode = listNode.next;
                count--;
            }while (count>0);
            preEnd = listNode;
        }
        return preResult.next;
    }
    public static ListNode work(ListNode head, int k){
        if(null==head||head.next == null||k<=1) return head;
        Queue<ListNode> queue = new LinkedList <>();
        queue.offer(head.next);
        queue.offer(head);
        for(int i=1;i<k;i++){
            ListNode listNode = queue.poll();
            queue.offer(listNode.next);
            queue.offer(listNode);
//            if(listNode.next==null){
//                head.next = null;
//                ListNode t1 = queue.poll();
//                queue.poll();
//                ListNode t2 = queue.poll();
//                t2.next = t1;
//                return t2;
//            }
            listNode.next = queue.poll();
        }
        head.next = queue.poll();
        return queue.poll();
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
//        a5.next = a6;
//        a6.next = a7;
        ListNode result = reverseKGroup(a1, 3);
        ListNode temp;
        for(;(temp = result.next)!=null;){
            System.out.println(temp.val);
            result = result.next;
        }
    }
}
