class Solution 
{
    public int maxFrequencyElements(int[] nums) 
    {
        int[] frequencyCount = new int[101];
        for (int num : nums) 
        {
            frequencyCount[num]++;
        }
        int totalCount = 0;
        int maxFrequency = -1;

        for (int frequency : frequencyCount) 
        {
            if (frequency > maxFrequency) 
            {
                maxFrequency = frequency;
                totalCount = frequency;
            } 
            else if (frequency == maxFrequency) 
            {
                totalCount += frequency;
            }
        }
        return totalCount;
    }
}