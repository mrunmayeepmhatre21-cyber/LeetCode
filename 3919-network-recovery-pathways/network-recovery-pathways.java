import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        int maxEdge = 0;
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            maxEdge = Math.max(maxEdge, e[2]);
        }

        int low = 0, high = maxEdge, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReach(graph, online, k, mid)) {
                ans = mid;      // feasible, try higher score
                low = mid + 1;
            } else {
                high = mid - 1; // not feasible, lower score
            }
        }
        return ans;
    }

    private boolean canReach(List<int[]>[] graph, boolean[] online, long k, int minEdge) {
        int n = graph.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{0, 0}); // {node, cost}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long costSoFar = cur[1];

            if (costSoFar > dist[u]) continue;
            if (u == n - 1 && costSoFar <= k) return true;

            for (int[] e : graph[u]) {
                int v = e[0], edgeCost = e[1];
                if (!online[v]) continue;       // must be online
                if (edgeCost < minEdge) continue; // edge must meet minEdge requirement

                long newCost = costSoFar + edgeCost;
                if (newCost < dist[v] && newCost <= k) {
                    dist[v] = newCost;
                    pq.add(new long[]{v, newCost});
                }
            }
        }
        return dist[n - 1] <= k;
    }
}
