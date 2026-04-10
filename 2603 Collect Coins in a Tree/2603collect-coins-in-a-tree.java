class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        Map<Integer, Set<Integer>> edgeList = initEdgeList(edges);
        //used for trimming leaf nodes with no coins
        Map<Integer, Boolean> hasCoins = initCoinMap(coins);
        int remainingEdges = trimTree(edgeList, hasCoins);
        //each edge that remains must be traversed exactly twice
        int minSteps = remainingEdges * 2;
        return minSteps;
    }

    private int trimTree(Map<Integer, Set<Integer>> edgeList, 
                                Map<Integer, Boolean> hasCoins) {
        //these nodes will never be traversed so we remove them all
        removeLeafNodesWithNoCoins(edgeList, hasCoins);
        //you can reach up to two nodes that have coins so remove all leaf nodes twice
        removeLeafNodes(edgeList, hasCoins, true);
        removeLeafNodes(edgeList, hasCoins, true);
        //a tree has nodeSize - 1 edges
        //if tree is zero nodes therefore 0 edges return 0 instead of -1
        return edgeList.size() > 1 ? edgeList.size() - 1 : 0;
    }

    private void removeLeafNodesWithNoCoins(Map<Integer, Set<Integer>> edgeList, 
                                            Map<Integer, Boolean> nodeToCoins) {
        removeLeafNodes(edgeList, nodeToCoins, false);
    }

    private void removeLeafNodes(Map<Integer, Set<Integer>> edgeList, 
                            Map<Integer, Boolean> hasCoins, boolean removeAnyNode) {
        LinkedList<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer> > entry : edgeList.entrySet()) {
            int node = entry.getKey();
            int nodeDegree = entry.getValue().size();
            //a leaf node has one edge
            if (nodeDegree == 1 && (removeAnyNode || !hasCoins.get(node)))
                q.addLast(node);
        }
        //removes leaf nodes with no coins
        //or if in onion peeling step, remove leaf nodes with or without coins
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int leafNode = q.pollFirst();
                Set<Integer> adjacentNodes = edgeList.get(leafNode);
                //removes leaf node from adjacent nodes edgelist
                //adds the adjacent node to queue
                //if it becomes a new leaf node with desired properties
                for (int adjacentNode : adjacentNodes) {
                    Set<Integer> adjacentNodeAdjacentNodes = edgeList.get(adjacentNode);
                    adjacentNodeAdjacentNodes.remove(leafNode);
                    int adjacentNodeDegree = adjacentNodeAdjacentNodes.size();
                    if (adjacentNodeDegree == 1 && 
                        (removeAnyNode || !hasCoins.get(adjacentNode)))
                        q.addLast(adjacentNode);
                }
                //remove leafNode from map since it will never be stepped on
                edgeList.remove(leafNode);
            }
            //only allowed one iteration if in step 2
            if (removeAnyNode)
                break;
        }
    }

    private Map<Integer, Boolean> initCoinMap(int[] coins) {
        Map<Integer, Boolean> hasCoins = new HashMap<>();
        for (int i = 0; i < coins.length; i++)
            hasCoins.put(i, coins[i] == 1);
        return hasCoins;
    }
    
    private Map<Integer, Set<Integer>> initEdgeList(int[][] edges) {
        Map<Integer, Set<Integer>> edgeList = new HashMap<>();
        for (int[] edge : edges) {
            edgeList.computeIfAbsent(edge[0], key -> new HashSet<Integer>())
                .add(edge[1]);
            edgeList.computeIfAbsent(edge[1], key -> new HashSet<Integer>())
                .add(edge[0]);
        }
        return edgeList;
    }
}