package Week2.problems;

import java.util.Scanner;

// Question: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/
// My Sollution: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/submissions/1891785227/

//My Approach: 
//

// TC: O()

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(minNumberOperations(arr));
    }

    public static int minNumberOperations(int[] target) {
        int n = target.length;
        int count = target[0];
        for(int i=1;i<n;i++){
                count+=Math.max(target[i]-target[i-1],0);
        }
        return count;
    }
}