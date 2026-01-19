package Week2.problems;
import java.util.Scanner;
import java.util.Stack;

// Question: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/
// My Sollution_1: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/submissions/1889528296/
// My Sollution_2: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/submissions/1889549886/

//My Approach_1: my brute force approach is to take a stringBuilder and copy the input string into it then we iterate over teh String builder over n over, 
//               while checking if any substring mathces the given windows, but the worst complextity can go upto n^2;
// My Appreoach _2: my optimal opprach is to take a stack and since the given window is only of two character we can chech the stack's top and current pointer and check wether, 
//                 it matches or not, this appeach is signifaclty better casue it's only n;

// TC: O(n)[optimal] // O(n^2) [Brute]


public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(minLength(s));
    }
    // public static int minLength(String s) {
    //     StringBuilder a = new StringBuilder(s);
    //     boolean flag = true;
    //     while(true){
    //         flag = true;
    //         for(int i = 0; i < a.length(); i++){
    //             if(a.substring(i).startsWith("AB") || a.substring(i).startsWith("CD")){
    //                 flag = false;
    //                 a.delete(i, i+2);
    //                 // System.out.println(a);
    //                 break;
    //             }
    //         }
    //         if(flag){
    //             break;
    //         }
    //     }
    //     // System.out.println(a);
    //     return a.length();
    // }

    public static int minLength(String s){
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            } else if ((st.peek()=='A' && c=='B')||(st.peek()=='C' && c =='D')) {
                st.pop();
            } else{
                st.push(c);
            }
        }
        return st.size();
    }
}