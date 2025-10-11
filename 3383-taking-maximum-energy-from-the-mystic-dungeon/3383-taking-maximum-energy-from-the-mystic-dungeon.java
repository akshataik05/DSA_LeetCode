class Solution 
{
    public int maximumEnergy(int[] energy, int k) 
    {
        int maxEnergy = -(1 << 30);
        int n = energy.length;
        for (int endPosition = n - k; endPosition < n; endPosition++) 
        {
            int currentSum = 0;
            for (int currentIndex = endPosition; currentIndex >= 0; currentIndex -= k) 
            {
                currentSum += energy[currentIndex];
                maxEnergy = Math.max(maxEnergy, currentSum);
            }
        }
        return maxEnergy;
    }
}
