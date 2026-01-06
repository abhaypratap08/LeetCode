/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new Node(node.val);

        HashMap<Node, Node> cp = new HashMap<>();
        Queue<Node> qu = new LinkedList<>();

        cp.put(node, new Node(node.val));
        qu.offer(node);

        while(!qu.isEmpty()) {
            Node curr = qu.poll();
            for(Node nei: curr.neighbors) {
                if(!cp.containsKey(nei)) {
                    cp.put(nei, new Node(nei.val));
                    qu.add(nei);
                }
                cp.get(curr).neighbors.add(cp.get(nei));
            }
        }
        return cp.get(node);
    }
}