import java.util.TreeMap;

class Solution 
{
    public int countPartitions(int[] nums, int k) 
    {
        final int MOD = (int)1e9 + 7;
        int n = nums.length;
        int[] dp = new int[n + 1];
        int[] prefixSum = new int[n + 1];
        dp[0] = 1;
        prefixSum[0] = 1;

        TreeMap<Integer, Integer> window = new TreeMap<>();
        int left = 1;

        for (int right = 1; right <= n; right++) 
        {
            int x = nums[right - 1];
            window.merge(x, 1, Integer::sum);

            while (window.lastKey() - window.firstKey() > k) 
            {
                int leftNum = nums[left - 1];
                int cnt = window.get(leftNum);
                if (cnt == 1) window.remove(leftNum);
                else window.put(leftNum, cnt - 1);
                left++;
            }

            int prev = prefixSum[right - 1];
            int exclude = (left >= 2) ? prefixSum[left - 2] : 0;
            dp[right] = ((prev - exclude) % MOD + MOD) % MOD;

            prefixSum[right] = (prefixSum[right - 1] + dp[right]) % MOD;
        }

        return dp[n];
    }
}
