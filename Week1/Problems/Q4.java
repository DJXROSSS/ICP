package Week1.Problems;

import java.util.Scanner;

// Question: https://leetcode.com/problems/count-primes/description/
// My Sollution: https://leetcode.com/problems/count-primes/submissions/1890152780/

//My Approach: using brute force in this question fails, so we have to use an algorithm called "Sieve of erastotenes", 
//             we diclare a boolean array representing the numbers via indexes, tthen we traverse over it and mark each of them as true, 
//             ie we are assuming all the number are prime, bu then we start from 2 and strt marking the mutliples of the current number as false, 
//              in the end we are left with true in prime numbers.

// TC: O(n log log n) 

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countPrimes(n));
    }
    
    public static int countPrimes(int n) {
        boolean[] arr = new boolean[n+1];
        for(int i = 0; i < n; i++){
            arr[i] = true;
        } 
        for(int i = 2; i * i <= n; i++){
            if(arr[i]){
                for(int j = i*i; j <= n; j+= i){
                    arr[j] = false;
                }
            }
        }
        int count = 0;
        for (int p = 2; p <= n; p++) {
            if (arr[p]) count++;
        }
        return count;
    }
}

