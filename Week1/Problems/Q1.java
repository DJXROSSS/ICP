package Week1.Problems;

import java.util.Scanner;
// Question Number: 121
// Question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// My Sollution: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1890125558/

// My apprpach: traverse through the array and keep track of the index contatining the min and max elements, 
//              while also keeping track of the condition that min can not go beyond max (u cannot buy in future),
// TC: O(n)

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxProfit(arr));
    }
    
    public static int maxProfit(int[] arr) {
        int n = arr.length;
        int min = 0;
        int max= 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(arr[min] > arr[i]){
                min = i;
            } else if(arr[max] < arr[i]){
                max = i;
            }
            if(min > max){
                max = min;
            }
            ans = Math.max(ans, arr[max] - arr[min]);
        }
        return ans;
    }
}