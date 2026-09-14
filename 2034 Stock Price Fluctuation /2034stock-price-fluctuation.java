class node implements Comparable<node>{
    int val;
    int time;
    
    public int compareTo(node n){
        if(this.val != n.val)
            return (this.val-n.val);
        
        return this.time-n.time;
    }
}

class StockPrice {

    int maxTime;
    HashMap<Integer, node> hm;
    TreeSet<node> set;
    public StockPrice() {
        hm = new HashMap<>();
        set = new TreeSet<node>();//(a,b)->(a.val-b.val));
        maxTime = -1;
    }
    
    public void update(int timestamp, int price) {
        if(hm.containsKey(timestamp)){
            set.remove(hm.get(timestamp));
        }
            node n = new node();
            n.val = price;
            n.time = timestamp;
            hm.put(timestamp, n);
            set.add(n);
        if(maxTime < timestamp)
            maxTime = timestamp;
    }
    
    public int current() {
        return hm.get(maxTime).val;
    }
    
    public int maximum() {
       return set.last().val;
    }
    
    public int minimum() {
       return set.first().val;   
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */