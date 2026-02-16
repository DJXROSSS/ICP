package Week4.problems;

// Question: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/
// My Sollution: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/submissions/1906358360/

// TC: O(N)


public class Q4 {

    public static void main(String[] args) {
        
    }
public ListNode doubleIt(ListNode head) {
        ListNode temp = rev(head);
        return rev(sum(temp, temp));
    }

    public static ListNode sum(ListNode l1, ListNode l2){
        ListNode ans = new ListNode();
        ListNode temp = ans;
        boolean CF = false;
        while(l1 != null || l2 != null){
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (CF){
                sum += 1;
                CF = false;
            }
            if(sum > 9){
                CF = true;
                sum -= 10;
            } 
            temp.next = new ListNode(sum);
            temp = temp.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (CF){
            temp.next = new ListNode(1);
        }
        return ans.next;
    }

    public static ListNode rev(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

}
