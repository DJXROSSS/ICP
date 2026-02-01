package Week3.Problems;

// Question: https://leetcode.com/problems/time-needed-to-buy-tickets/description/
// My Sollution: https://leetcode.com/problems/time-needed-to-buy-tickets/submissions/

// TC: O()

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(timeRequiredToBuy(arr, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                total += Math.min(tickets[i], tickets[k]);
            } else {
                total += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return total;
    }

}