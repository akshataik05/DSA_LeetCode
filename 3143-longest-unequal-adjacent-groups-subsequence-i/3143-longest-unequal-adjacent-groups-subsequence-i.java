class Solution 
{
    public List<String> getLongestSubsequence(String[] words, int[] groups) 
    {
        int arrayLength = groups.length;
        List<String> result = new ArrayList<>();
        for (int index = 0; index < arrayLength; index++) 
        {
            if (index == 0 || groups[index] != groups[index - 1]) 
            {
                result.add(words[index]);
            }
        }
        return result;
    }
}
