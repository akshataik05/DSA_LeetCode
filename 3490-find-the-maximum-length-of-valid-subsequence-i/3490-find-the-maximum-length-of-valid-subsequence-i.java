class Solution 
{
    public int maximumLength(int[] nums) 
    {
        int modValue = 2;
        int[][] dp = new int[modValue][modValue];
        int maxLength = 0;

        for (int num : nums) 
        {
            int currentRemainder = num % modValue;
            for (int targetSum = 0; targetSum < modValue; ++targetSum) 
            {
                int previousRemainder = (targetSum - currentRemainder + modValue) % modValue;
                dp[currentRemainder][previousRemainder] = dp[previousRemainder][currentRemainder] + 1;
                maxLength = Math.max(maxLength, dp[currentRemainder][previousRemainder]);
            }
        }

        return maxLength;
    }
}
