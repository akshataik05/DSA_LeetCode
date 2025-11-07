import java.util.*;

class Solution 
{
  public long maxPower(int[] stations, int r, int k) 
  {
    int n = stations.length;
    long sum = 0;
    for (int v : stations) sum += v;

    long left = 0;
    long right = sum + k; 
    while (left <= right) 
    {
      long mid = left + (right - left) / 2;
      if (check(stations, r, k, mid))
        left = mid + 1;
      else
        right = mid - 1;
    }
    return right;
  }

  private boolean check(int[] stations, int r, int additionalStations, long minPower) 
  {
    int n = stations.length;
    
    long[] base = new long[n];
    long cur = 0;
    int rightBound = Math.min(n - 1, r);
    for (int j = 0; j <= rightBound; ++j) cur += stations[j];
    base[0] = cur;
    for (int i = 1; i < n; ++i) 
    {
      int outIdx = i - r - 1;
      if (outIdx >= 0) cur -= stations[outIdx];
      int inIdx = i + r;
      if (inIdx < n) cur += stations[inIdx];
      base[i] = cur;
    }
    
    long[] removals = new long[n + 1]; 
    long addedInWindow = 0; 
    long remain = additionalStations;

    for (int i = 0; i < n; ++i) 
    {

      addedInWindow -= removals[i];

      long currentPower = base[i] + addedInWindow;
      if (currentPower < minPower) 
      {
        long need = minPower - currentPower;
        if (need > remain) return false; 
        remain -= need;
        addedInWindow += need;
    
        int pos = Math.min(n - 1, i + r);
        int removeIndex = pos + r + 1; 
        if (removeIndex <= n) 
        {
          removals[removeIndex] += need;
        }
      }
    }
    return true;
  }
}
