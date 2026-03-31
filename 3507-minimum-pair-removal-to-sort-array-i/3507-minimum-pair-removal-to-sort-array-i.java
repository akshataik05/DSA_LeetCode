class Solution 
{
    public int minimumPairRemoval(int[] nums) 
    {
        List<Integer> arr = new ArrayList<>();
        for (int num:nums) 
        {
            arr.add(num);
        }
        int operations=0;
        while(!isNonDecreasing(arr)) 
        {
            int minSum = arr.get(0)+arr.get(1);
            int index = 0;
            for(int i=1;i<arr.size()-1;i++) 
            {
                int sum=arr.get(i)+arr.get(i+1);
                if(sum<minSum) 
                {
                    minSum = sum;
                    index = i;
                }
            }
            arr.set(index, minSum);
            arr.remove(index + 1);
            operations++;
        }

        return operations;
    }
    private boolean isNonDecreasing(List<Integer> arr) 
    {
        for (int i = 1; i<arr.size();i++) 
        {
            if (arr.get(i)<arr.get(i - 1)) 
            {
                return false;
            }
        }
        return true;
    }
}