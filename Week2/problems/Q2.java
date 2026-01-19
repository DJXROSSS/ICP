package Week2.problems;
import java.util.Scanner;
import java.util.Stack;

// Question: https://leetcode.com/problems/make-the-string-great/description/
// My Sollution: https://leetcode.com/problems/make-the-string-great/submissions/1889561313/

//My Approach: in this we use a stack to keep track of the small and larger elements, if the we incounter two character with diff == 32,
//             means ther are teh uppercase and lowercase counterparts, we remove theem fromthe staack.
//             another apperach can to simly travers teh string with i and i+1 idx with a stringbuilder

// TC: O(n)

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(makeGood(s));
        // System.out.println('a' - 'A');
    }

    public static String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            } else if(Math.abs(c - st.peek()) == 32){
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
