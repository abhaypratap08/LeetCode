class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> arr=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            arr.put(nums[i],arr.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> map=new ArrayList<>();
        int m=0;
        boolean f=true;
        for(int i:arr.keySet()){
            if(m<arr.get(i) && i%2==0){
                m=arr.get(i);
            }
        }
        for(int i:arr.keySet()){
            if(arr.get(i)==m && i%2==0){
                map.add(i);
                f=false;
            }
        }
        Collections.sort(map);

        if(!f){
        return map.get(0);
        }
        return -1;
    }
}