package Week1.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Question Number: 15
// Question: https://leetcode.com/problems/3sum/description/
// My Sollution: https://leetcode.com/problems/3sum/submissions/1890143440/

// My Approach: We are supposed to find triplets, using teh brute force reaches 0(n^3), which gives TLE, 
//             in order to solve this, we first sort the array, keeping a pointer and fixing it, while usingg two pointer to find the sum resulting in
//             -nums[i] + (nums[j] + nums[k]) == 0
// TC: O(n^2)

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1; 
            int k = n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                } else if(sum < 0){
                    j++;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return ans;
    }
    
}