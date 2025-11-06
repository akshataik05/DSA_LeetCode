import java.util.*;

public class Solution {
    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; ++i) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            if (rank[ra] < rank[rb]) parent[ra] = rb;
            else if (rank[ra] > rank[rb]) parent[rb] = ra;
            else { parent[rb] = ra; rank[ra]++; }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);
        for (int[] e : connections) dsu.union(e[0], e[1]);

        Map<Integer, TreeSet<Integer>> comp = new HashMap<>();
        for (int i = 1; i <= c; ++i) {
            int r = dsu.find(i);
            comp.computeIfAbsent(r, k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);
        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            if (type == 1) {
                if (online[x]) ans.add(x);
                else {
                    int r = dsu.find(x);
                    TreeSet<Integer> ts = comp.get(r);
                    ans.add(ts == null || ts.isEmpty() ? -1 : ts.first());
                }
            } else if (type == 2) {
                if (online[x]) {
                    online[x] = false;
                    int r = dsu.find(x);
                    TreeSet<Integer> ts = comp.get(r);
                    if (ts != null) ts.remove(x);
                }
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) res[i] = ans.get(i);
        return res;
    }
}
