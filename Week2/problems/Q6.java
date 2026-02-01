package Week2.problems;

import java.util.Scanner;
import java.util.Stack;

// Question: https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/description/
// My Sollution: https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/submissions/1891866783/


// TC: O()

public class Q6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =  sc.next();
        int k = sc.nextInt();
        char letter = sc.next().toCharArray()[0];
        int r = sc.nextInt();
        System.err.println(
            smallestSubsequence(s, k, letter, r)     
        );
    }


    public static String smallestSubsequence(String s, int k, char letter, int r) {
        // count the occurances
        int n_letters = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == letter)
                n_letters ++;
        
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //pop condition
            // if stack is empty or top > c or we have enough chars or enough letter
            while (!stack.isEmpty() && stack.peek() > c && (s.length() - i + stack.size() > k) && (stack.peek() != letter || n_letters > r)) {
                if (stack.pop() == letter) r ++;
            }
            //push condition
            // if stack size >k or if letter  or enough room 
            if (stack.size() < k) {
                if (c == letter) {
                    stack.push(c);
                    r --;
                } else if (k - stack.size() > r) {
                    stack.push(c);
                }
            }
            
            if (c == letter) n_letters --;
        }
        
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c : stack) sb.append(c);
        return sb.toString();
    }
    
}