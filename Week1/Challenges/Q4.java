package Week1.Challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }    
        List<List<Integer>> sets = new ArrayList<>();
        subset(n, arr, 0, new ArrayList<>(), sets);
        sets.remove(0);
        System.out.print(sum(sets) % 1000000007);
    }

    public static long sum(List<List<Integer>> subsets){
        long ans = 0;
        for(List<Integer> list: subsets){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i: list){
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            ans += (max * max) * min;
        }
        return ans;
    }

    public static void subset(int n, int[] arr, int i, List<Integer> curr, List<List<Integer>> ans){
        if(i == n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        subset(n, arr, i+1, curr, ans);
        curr.add(arr[i]);
        subset(n, arr, i+1, curr, ans);
        curr.remove(curr.size()-1);
    }

}