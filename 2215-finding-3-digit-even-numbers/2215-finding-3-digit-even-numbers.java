import java.util.*;

class Solution 
{
  public int[] findEvenNumbers(int[] digits) 
  {
    int[] count = new int[10];
    for (int d : digits) count[d]++;

    List<Integer> ans = new ArrayList<>();

    for (int num = 100; num < 1000; num += 2) 
    {
      int a = num / 100;
      int b = (num / 10) % 10;
      int c = num % 10;

      count[a]--;
      count[b]--;
      count[c]--;

      if (count[a] >= 0 && count[b] >= 0 && count[c] >= 0) 
      {
        ans.add(num);
      }

      count[a]++;
      count[b]++;
      count[c]++;
    }

    int[] result = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
    return result;
  }
}
