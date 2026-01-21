package Week2.problems;
import java.util.Scanner;
import java.util.Stack;

// Question: https://leetcode.com/problems/sum-of-subarray-minimums/description/
// My Sollution: https://leetcode.com/submissions/detail/1891500840/

//My Approach: We use a monotonic stack to keep track of the minimun of sub array, and use two pointers i and j to controll the subarray.
//

// TC: O(n*k)

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        int j, k;
        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > (i == len ? Integer.MIN_VALUE : arr[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                sum += (long)arr[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }
        return (int)(sum % (long) (1e9 + 7));
    }

    // public static int sumSubarrayMins(int[] arr) {
    //     int n = arr.length;
    //     long sum = 0;
    //     for (int i = 0; i < n; i++) {
    //         int min = arr[i];
    //         for (int j = i; j < n; j++) {
    //             min = Math.min(min, arr[j]);
    //         }
    //         sum += min;
    //     }
    //     return (int) (sum  % 1_000_000_007);
    // }
}
