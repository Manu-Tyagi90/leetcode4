package leetcode1;
// https://leetcode.com/problems/add-two-numbers/
public class p2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);
        
        Solution1 solution = new Solution1();
        ListNode Result = solution.addTwoNumbers(l1,l2);
        
        while (Result!=null) {
            System.out.print(Result.val);
            Result = Result.next;
        }
    
    }
    
    
}

class Solution1{
    public ListNode addTwoNumbers(ListNode L1,ListNode L2){
        ListNode Dummy = new ListNode(0);
        ListNode Current = Dummy;

        while (L1!=null && L2!=null ) {
            if(L1.val<L2.val){
                Current.next = L1;
                L1=L1.next;
            }

            else if(L2.val<=L1.val){
                Current.next = L2;
                L2=L2.next;
            }
            Current = Current.next;
        }

        if(L1!=null){
            Current.next = L1;
        }
        else{
            Current.next = L2;
        }

        return Dummy.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
