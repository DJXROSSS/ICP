package Week4.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Question: https://leetcode.com/problems/next-greater-node-in-linked-list/description/
// My Sollution: https://leetcode.com/problems/next-greater-node-in-linked-list/submissions/1921479982/

// TC: O(N)

public class Q6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <n ; i++) arr[i] = sc.nextInt();
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        int n = arr.size();
        int[] ans = new int[n];
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(arr.get(j) > arr.get(i)){
                    ans[i] = arr.get(j);
                    break;
                }
            }
        }
        return ans;
    }
}