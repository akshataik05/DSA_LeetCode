class Solution 
{
  public long countSubarrays(int[] nums, long k) 
  {
    long subarrays = 0;
    long sum = 0;

    for (int l = 0, r = 0; r < nums.length; r++) 
    {
      sum += nums[r];
      while (sum * (r - l + 1) >= k)
        sum -= nums[l++];
      subarrays += r - l + 1;
    }
    return subarrays;
  }
}