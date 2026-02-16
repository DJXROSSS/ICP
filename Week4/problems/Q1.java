package Week4.problems;

// Question: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
// My Sollution: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/1905073303/

// TC: O(N)

import java.util.Scanner;

public class Q1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            ListNode ll = LinkedListUtil.build(arr);
            System.out.print(getDecimalValue(ll));
        }
    
    public static int getDecimalValue(ListNode head) {
        StringBuilder s = new StringBuilder();
        while(head != null){
            s.append(head.val);
            head = head.next;
        }
        int ans = Integer.valueOf(s.toString(), 2);
        return ans;
    }
}