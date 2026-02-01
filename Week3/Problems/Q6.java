package Week3.Problems;

// Question: https://leetcode.com/problems/jump-game-vi/
// My Sollution: 

// TC: O()

import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxResult(arr, k));
    }

    public static int maxResult(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; ){
            sum += nums[i];
            int idx = -1; 
            int max = Integer.MIN_VALUE;
            for(int j = i; (j < i+k) && (j <= n-1) ; j++){
                if(j == i) continue;
                if(nums[j] >= max){
                    max = nums[j];
                    idx = j;
                    System.out.println(idx + "___");
                }
            }

            i = idx;
        }
        return sum;
    }
}