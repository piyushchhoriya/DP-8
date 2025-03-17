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

//Optimal DP approach
In this approach we are taking an dp matrix of length n and we are calculating at that element how many slices are there. We will start
To iterate from i=2 or we can also start form i=n-2 i.e from end. at every index if the difference between 3 elements in equal then we 
will add 1 with previous element value
Time Complexity : O(n)
Space Complexity : O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        int count = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=2;i<n;i++){
            if(nums[i-1] - nums[i-2] == nums[i]-nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            count=count+dp[i];
        }
            
        return count;
    }
}

As we are just looking through the previous value we can optimize it instead of the dp array we can store the previous value in a 
variable and refer to it.
Time Complexity : O(n)
Space Complexity : O(1) -> here we are not using an extra space

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        int count = 0;
        int n = nums.length;
        int prev=0;
        for(int i=2;i<n;i++){
            if(nums[i-1] - nums[i-2] == nums[i]-nums[i-1]){
                prev=prev+1;
            }
            else{
                prev=0;
            }
            count=count+prev;
        }
            
        return count;
    }
}