package Week1.Challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxCandyType(arr));
    }

    public static int maxCandyType(int[] candies){
        List<Integer> list = new ArrayList<>();
        for(int i: candies)
            if (!list.contains(i))
                list.add(i);
        int total = candies.length/2;
        int types = list.size();
        if(types == 1) return 1;
        if (types >= total) return total;
        return types;
    }
}
