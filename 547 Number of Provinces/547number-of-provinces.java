class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return;

            if(rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if(rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }

        int provinces = 0;
        for(int i = 0; i < n; i++) {
            if(dsu.find(i) == i) provinces++;
        }

        return provinces;
    }
}