class Solution 
{
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) 
    {
        int n = groups.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxLength = 1;
        for (int i = 0; i < n; ++i) 
        {
            for (int j = 0; j < i; ++j) 
            {
                if (groups[i] != groups[j] &&
                    dp[i] < dp[j] + 1 &&
                    isDifferByOneChar(words[i], words[j])) 
                    {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) 
        {
            if (dp[i] == maxLength) 
            {
                for (int currentIndex = i; currentIndex >= 0; currentIndex = parent[currentIndex]) 
                {
                    result.add(words[currentIndex]);
                }
                break;
            }
        }
        Collections.reverse(result);
        return result;
    }

    private boolean isDifferByOneChar(String s, String t) 
    {
        if (s.length() != t.length()) 
        {
            return false;
        }
        int differenceCount = 0;
        for (int i = 0; i < s.length(); ++i) 
        {
            if (s.charAt(i) != t.charAt(i)) 
            {
                ++differenceCount;
            }
        }
        return differenceCount == 1;
    }
}
