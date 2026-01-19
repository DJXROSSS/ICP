package Week2.problems;
import java.util.Scanner;

// Question: https://leetcode.com/problems/sum-of-subarray-minimums/description/
// My Sollution: 

//My Approach: 
//

// TC: O()

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
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                System.out.print(arr[j]);
            }
            System.out.println();
        }
        return 0;
    }
}
