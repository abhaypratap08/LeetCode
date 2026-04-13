class Solution {

    //using long as we are multiplying and it can have (32bits)Integer overflow. So, long(64bits) will have more memory to store.
    HashMap<Long, List<Long>> map = new HashMap<>();
    int totalNodes = 0;
    long maxscore = 0;

    public int countHighestScoreNodes(int[] parents) {
        TreeNode root = createTree(parents);
        totalNodes = parents.length;
        calculateScores(root);
        return map.get(maxscore).size();
    }

    public int calculateScores(TreeNode node){
        if(node == null) return 0;

        int leftSize = calculateScores(node.left);
        int rightSize = calculateScores(node.right);

        long score = 1;
        if(leftSize != 0) score *= leftSize; //this is for the left side to multiply the value 
        if(rightSize != 0) score *= rightSize;//this is for the right side to multiply the value 

        //this tells us that if we remove parent node, then left side 
        if(totalNodes - leftSize - rightSize -1 != 0){
            score *= (totalNodes - leftSize - rightSize -1); 
        }


        maxscore = Math.max(score, maxscore);//to check the max out of the nodes.

        map.putIfAbsent(score, new ArrayList<>());//with every score add the number of does in the list.
        map.get(score).add((long)node.val);//add the val in it.

        return leftSize + rightSize +1;
    }

    public TreeNode createTree(int[] parents){
        int n = parents.length;
        TreeNode[] nodes = new TreeNode[n]; 

        //will create a TreeNode of the index and use this index for the parents.
        for(int i = 0; i<n;i++){
            nodes[i] = new TreeNode(i);//[0,1,2,3,4]
        }

        TreeNode root = null;
        //[-1, 2, 0,2,0]
        for(int i = 0; i<n;i++){
            
            if(parents[i] == -1) root = nodes[i];//will add the 0 in the parent.
            else{
                TreeNode parent = nodes[parents[i]];//2 , 0 , 2, 0
                if(parent.left == null){
                    parent.left = nodes[i];//2-->1 , 0-->2
                }else{
                    parent.right = nodes[i];//2-->3, 0--> 4
                }
            }
        }

        return root;
    }

}