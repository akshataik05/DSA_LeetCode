class Solution 
{
    public int countTrapezoids(int[][] points) 
    {
        final long MOD = 1_000_000_007L;
        java.util.HashMap<Integer,Integer> cnt = new java.util.HashMap<>();
        for (int[] p : points) cnt.put(p[1], cnt.getOrDefault(p[1], 0) + 1);
        long S = 0L, T = 0L;
        for (int c : cnt.values()) 
        {
            if (c >= 2)
             {
                long x = (long)c * (c - 1) / 2 % MOD;
                S = (S + x) % MOD;
                T = (T + (x * x) % MOD) % MOD;
            }
        }
        long ans = ((S * S) % MOD - T + MOD) % MOD;
        long inv2 = (MOD + 1) / 2;
        ans = (ans * inv2) % MOD;
        return (int) ans;
    }
}
