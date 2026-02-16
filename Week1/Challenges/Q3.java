package Week1.Challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
    }

    public static int distictProducts(int[] arr){
        // from the given question, we can solve it by using permuation with recursiona nd setting a base condition usign hash map
        
        List<Integer> list = new ArrayList();
        int ans = 0;
        for(int i: arr){
            if(list.contains(i)){
                ans++;
                list.clear();
            } else {
                list.add(i);
            }
        }
        if(!list.isEmpty()){
            ans++;
            list.clear();
        }
        return ans;
    }
}