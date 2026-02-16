package Week4.problems;

// Question: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
// My Sollution: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/1905118438/

// TC: O(N)


import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ListNode ll = LinkedListUtil.build(arr);
        System.out.print(deleteMiddle(ll));
    }

    public static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode mid = mid(head);
        ListNode temp = head;
        while (temp.next != mid){
            temp = temp.next;
        }
        temp.next = mid.next;
        return head;
    }

    public static ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
