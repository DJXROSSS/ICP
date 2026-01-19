package Week1.Problems;

import java.util.Scanner;

// Question: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// My Sollution: https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/1890290185/

//My Approach: first we combine the two array into one and if the size of combined array is odd then return middle index, 
//             if even then take the two middle elements and retun the avg.
//

// TC: O(m+n)

public class Q6 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] arr2 = new int[m];
        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println(findMedianSortedArrays(arr, arr2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nums = new int[n+m];
        int idx = 0;
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                nums[idx++] = nums1[i++];
            } else{
                nums[idx++] = nums2[j++];
            }
        }
        while (i < n) {
            nums[idx++] = nums1[i++];
        }
        while (j < m) {
            nums[idx++] = nums2[j++];
        }
        d(nums);
        double ans = 0;
        if (nums.length % 2 == 0) {
            ans = (nums[nums.length/2] + nums[nums.length/2 - 1]);
            ans = ans/2;
        } else{
            ans = nums[nums.length/2];
        }
        return ans;
    }
    public static void d(int[]arr){
        for(int i: arr) System.out.print(i + " ");
    }
}