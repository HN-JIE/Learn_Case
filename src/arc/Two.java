package arc;

public class Two {
    public static void main(String[] args) {
        ListNode l1 = makeListNode(new int[]{1},0,0);
        ListNode l2 = makeListNode(new int[]{9,9},0,1);
        ListNode result =addTwoNumbers(l1,l2);
        int a=0;
    }
    public static ListNode makeListNode(int[]data,int start,int end){
        ListNode listNode = new ListNode(-1);
        if(start<=end){
            listNode.val=data[start];
            listNode.next=makeListNode(data,start+1,end);
        } else{
            return null;
        }
        return listNode;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Boolean flag =false;
        if(sum(l1,l2,flag)==2){
            return l2;
        }else {
            return l1;
        }
    }

    public static int sum(ListNode l1, ListNode l2,Boolean flag){
        if(l2==null){
            if(flag){
                l1.val=l1.val+1;
                if(l1.val>=10){
                    l1.val=l1.val%10;
                    if(l1.next==null){
                        if(flag){
                            l1.next = new ListNode(1);
                        }
                        return 1;
                    }
                    return sum(l1.next,null,true);
                }
            }
            return 1;
        }else if(l1==null){
            if(flag){
                l2.val=l2.val+1;
                if(l2.val>=10){
                    l2.val=l2.val%10;
                    if(l2.next==null){
                        if(flag){
                            l2.next = new ListNode(1);
                        }
                        return 2;
                    }
                    return sum(null,l2.next,true);
                }
            }
            return 2;
        }else {
            l1.val=l1.val+l2.val;
            if(flag){
                l1.val=l1.val+1;
            }
            if(l1.val>=10){
                l1.val=l1.val%10;
                flag=true;
            }else {
                flag=false;
            }
            l2.val=l1.val;

            if(l1.next==null&&l2.next==null){
                if(flag){
                    l1.next = new ListNode(1);
                }
                return 0;
            }
            return sum(l1.next,l2.next,flag);
        }
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }