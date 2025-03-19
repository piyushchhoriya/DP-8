## Problem1 Arithmetic Slices (https://leetcode.com/problems/arithmetic-slices/)

//BruteForce approach 
We can generate the subsequence of length 4 or more and then we can check if difference is same or not
Time Complexity : O(n^2)
Space Complexity : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        int count = 0;
        int n = nums.length;
        for(int i=1;i<n-1;i++){
            for(int j=i;j<n-1;j++){
                if(nums[j]-nums[j-1] == nums[j+1]-nums[j]){
                    count++;
                }
                else{
                    break;
                }
            }
        }
            
            
        return count;
    }
}