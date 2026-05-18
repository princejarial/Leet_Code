class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        boolean[] vis = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // {cost, node}

        pq.add(new int[]{0, 0});
        int cost = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int wt = curr[0];
            int u = curr[1];

            if(vis[u]) continue;
            vis[u] = true;
            cost += wt;

            for(int v = 0; v < n; v++){
                if(!vis[v]){
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                               Math.abs(points[u][1] - points[v][1]);

                    if(dist < minDist[v]){
                        minDist[v] = dist;
                        pq.add(new int[]{dist, v});
                    }
                }
            }
        }
        return cost;
    }
}