package Week3.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Question: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
// My Sollution: https://leetcode.com/problems/find-the-winner-of-the-circular-game/submissions/1901851939/

// TC: O(N*K)


import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println((arr));
    }

    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }
        while(q.size() > 1){
            for(int i = 1; i < k; i++){
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }
}