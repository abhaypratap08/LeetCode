class data
{
    int userid=0;
    int priority=0;
    public data(int u,int p)
    {
        this.userid=u;
        this.priority=p;
    }
}
class tuple
{
    int u=0;
    int t=0;
    int p=0;
    public tuple(int u,int t,int p)
    {
        this.u=u;
        this.t=t;
        this.p=p;
    }
     
}

class TaskManager {

    HashMap<Integer,data>map=new HashMap<>();

   PriorityQueue<tuple> q = new PriorityQueue<>((a, b) -> {
    if (b.p != a.p) return b.p - a.p; 
    return b.t - a.t; 
});

    public TaskManager(List<List<Integer>> tasks) 
    {
        for(List<Integer>t:tasks)
        {
            int user=t.get(0);
            int task=t.get(1);
            int prior=t.get(2);

            map.put(task,new data(user,prior));

            q.add(new tuple(user,task,prior));
        }
        
    }
    
    public void add(int userId, int taskId, int priority) 
    {

        map.put(taskId,new data(userId,priority));
        q.add(new tuple(userId,taskId,priority));
        
    }
    
    public void edit(int taskId, int newPriority) 
    {
        data d=map.get(taskId);
       
        map.put(taskId,new data(d.userid,newPriority));
        q.add(new tuple(d.userid,taskId,newPriority));

    }
    
    public void rmv(int taskId) 
    {
        map.remove(taskId);
        
    }
    
    public int execTop() 
    {
        while(q.isEmpty()==false)
        {
            tuple t=q.poll();
            data d=map.get(t.t);
            if (d != null && d.priority == t.p && d.userid == t.u) {
                map.remove(t.t); 
                return t.u;
            }
        }
       return -1;
        
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */