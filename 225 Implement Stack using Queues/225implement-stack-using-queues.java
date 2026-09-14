class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
    }
}

class MyStack {
    Node top;
    int size;

    public MyStack() {
        top = null;
        size = 0;
    }
    
    public void push(int x) {
        Node newNode = new Node(x);   
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    public int pop() {
        int val = top.data;
        top = top.next;
        //size--;
        return val;
    }
    
    public int top() {
        return top.data;
    }
    
    public boolean empty() {
        return top == null;
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */