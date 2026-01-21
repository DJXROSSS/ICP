package Week2.problems;

import java.util.Scanner;
import java.util.Stack;

// Question: https://leetcode.com/problems/maximum-subarray-min-product/description/
// My Sollution: 

//My Approach: 
//

// TC: O()

public class Q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxSumMinProduct(arr));
    }
    
    public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Stack<Integer> stack = new Stack<>();
        long max = 0;

        for (int i = 0; i <= n; i++) {
            int cur = (i == n) ? 0 : nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] > cur) {
                int idx = stack.pop();
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int right = i - 1;

                long sum = prefix[right + 1] - prefix[left];
                max = Math.max(max, sum * nums[idx]);
            }
            stack.push(i);
        }

        return (int) (max % 1_000_000_007);
    }
}
