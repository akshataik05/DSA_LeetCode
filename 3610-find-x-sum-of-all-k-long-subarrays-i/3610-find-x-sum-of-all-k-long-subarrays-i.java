class Solution 
{
    private TreeSet<int[]> topElements = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    private TreeSet<int[]> remainingElements = new TreeSet<>(topElements.comparator());
    private Map<Integer, Integer> frequencyMap = new HashMap<>();
    private int currentSum;

    public int[] findXSum(int[] nums, int k, int x) 
    {
        int n = nums.length;
        int[] result = new int[n - k + 1];
      
        for (int i = 0; i < n; ++i) 
        {
            int currentValue = nums[i];
            removeFromSets(currentValue);
            frequencyMap.merge(currentValue, 1, Integer::sum);
            addToSets(currentValue);
            int windowStart = i - k + 1;
            if (windowStart < 0) continue;
            while (!remainingElements.isEmpty() && topElements.size() < x) 
            {
                int[] element = remainingElements.pollLast();
                currentSum += element[0] * element[1];
                topElements.add(element);
            }
          
            while (topElements.size() > x) 
            {
                int[] element = topElements.pollFirst();
                currentSum -= element[0] * element[1];
                remainingElements.add(element);
            }

            result[windowStart] = currentSum;
            removeFromSets(nums[windowStart]);
            frequencyMap.merge(nums[windowStart], -1, Integer::sum);
            addToSets(nums[windowStart]);
        }
        return result;
    }

    private void removeFromSets(int value) 
    {
        if (!frequencyMap.containsKey(value)) return;
        int[] element = new int[] {frequencyMap.get(value), value};
        if (topElements.contains(element)) 
        {
            topElements.remove(element);
            currentSum -= element[0] * element[1];
        } else 
        {
            remainingElements.remove(element);
        }
    }

    private void addToSets(int value) 
    {
        if (!frequencyMap.containsKey(value)) return;
        int[] element = new int[] {frequencyMap.get(value), value};
        if (!topElements.isEmpty() && 
            topElements.comparator().compare(topElements.first(), element) < 0) 
            {
            topElements.add(element);
            currentSum += element[0] * element[1];
        } else {
            remainingElements.add(element);
        }
    }
}
