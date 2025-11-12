class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map = new HashMap<>();
        int n = names.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(names[i])){
                int val = map.get(names[i]);
                StringBuilder s = new StringBuilder(names[i]);
                s.append('(');
                s.append(val);
                s.append(')');

                while(map.containsKey(s.toString())){
                    val++;
                    s = new StringBuilder(names[i]);
                    s.append('(');
                    s.append(val);
                    s.append(')');
                }

                map.put(s.toString(),1);
                map.put(names[i],val+1);
                names[i] = s.toString();
            }
            else{
                map.put(names[i],1);
            }
        }
        return names;
    }
}