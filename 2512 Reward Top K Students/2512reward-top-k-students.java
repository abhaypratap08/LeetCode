class pair{
    int id;
    int marks;
    pair(int id,int marks){
        this.id=id;
        this.marks=marks;
    }
}
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pf = new HashSet<>();
        for(String s : positive_feedback){
            pf.add(s);
        }
        HashSet<String> nf = new HashSet<>();
        for(String s : negative_feedback){
            nf.add(s);
        }
        //declare a priorityqueue which 
        PriorityQueue<pair>pq =new PriorityQueue<>((a,b)->{
            if(a.marks!=b.marks) return Integer.compare(b.marks,a.marks);
            else return Integer.compare(a.id,b.id);
        });
        for(int i=0;i<report.length;i++){
            int score=0;
            String[] str = report[i].split(" ");
            for(int j=0;j<str.length;j++){
                if(pf.contains(str[j])){
                    score+=3;
                }
                if(nf.contains(str[j])){
                    score-=1;
                }
            }
            pq.add( new pair(student_id[i],score));
        }
        List<Integer> res = new ArrayList<>();

        while(!pq.isEmpty()&&k>0){
            pair p = pq.poll();
            res.add(p.id);
            k--;
        }
        return res;
    }
}