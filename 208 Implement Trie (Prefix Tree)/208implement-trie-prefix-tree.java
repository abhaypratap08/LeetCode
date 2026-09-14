class Trie {

    private static class Node {
        private char data;
        private boolean isEnd;
        private Node[] children;

        public Node(char data) {
            this.data = data;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }
    private Node root;
    public Trie() {
        root = new Node('/');
    }
    
    public void insert(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new Node(word.charAt(i));
            }
            curr = curr.children[childIdx];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if(curr.children[childIdx] == null){
                return false;
            } 
            curr = curr.children[childIdx];
        }
        return curr.isEnd == true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			int childIdx = prefix.charAt(i) - 'a';
			if (curr.children[childIdx] == null) {
				return false;
			}
			curr = curr.children[childIdx];
		}
		return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */