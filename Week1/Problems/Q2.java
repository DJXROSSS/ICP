package Week1.Problems;
import java.util.Scanner;

// Question Number: 28
// Question: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// My sollution_1: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/1883633568/
// My sollution_2: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/1890135814/

// My Appaoch: We'll traverse the haystack and check if the current substring matches the needle. (Sliding window)
//             or we can just use the inbuilt function "indexOf()" which does the same.
// TC: O(n*K) 

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.next("Enter the haystack: ");
        String needle = sc.next("Enter the needle: ");
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int k = needle.length();
        if(n < k){
            return -1;
        }
        for(int i = 0; i <= n-k; i++){
            if(haystack.substring(i, i+k).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    
    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}