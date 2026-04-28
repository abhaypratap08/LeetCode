/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> allLvls = new ArrayList<>();
        
        
        if (root == null)
            return allLvls;
        
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        
        while (!q.isEmpty()) {
            int l = q.size();
            List<Integer> currLvl = new ArrayList<>();
            
            
            for (int i = 0; i < l; i++) {
                Node n = q.remove();
                currLvl.add(n.val);
                
                
                for (Node child : n.children)
                    q.add(child);
            }
            
            
            allLvls.add(currLvl);
        }
        
        
        return allLvls;
    }
}