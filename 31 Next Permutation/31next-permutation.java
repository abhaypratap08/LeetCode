class Solution {
    public void nextPermutation(int[] nums) {
        int indx1=-1;
        int indx2=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                indx1=i;
                break;
            }
        }
        if(indx1==-1){
            reverse(nums,0);
        }
        else{
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[indx1]){
                    indx2=i;
                    break;
                }
            }
            swap(nums,indx1,indx2);
            reverse(nums,indx1+1);
        }
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}