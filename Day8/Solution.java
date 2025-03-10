package Day8;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, window = 0, ans = 0;
        int n = nums.length;

        for (; right < n; right++) {
            window += nums[right]; 

            
            while (window + k < right - left + 1) {
                window -= nums[left]; 
                left++;
            }

            ans = Math.max(ans, right - left + 1); 
        }

        return ans;
    }
}

