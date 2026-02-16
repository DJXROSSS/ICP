package Week4.problems;

import java.util.Scanner;

// Question: https://leetcode.com/problems/steps-to-make-array-non-decreasing/
// My Sollution: https://leetcode.com/problems/steps-to-make-array-non-decreasing/submissions/1909964082/

// TC: O(N)

public class Q5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <n ; i++) arr[i] = sc.nextInt();
    }

    public static int totalSteps(int[] A) {
        int n = A.length, res = 0, j = -1;
        int dp[] = new int[n], stack[] = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (j >= 0 && A[i] > A[stack[j]]) {
                dp[i] = Math.max(++dp[i], dp[stack[j--]]);
                res = Math.max(res, dp[i]);
            }
            stack[++j] = i;
        }
        return res;
    }
}