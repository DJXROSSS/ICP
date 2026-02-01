package Week3.Problems;

// Question: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/
// My Sollution: 

// TC: O()

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        // System.out.println(threeSum(arr));
    }
}