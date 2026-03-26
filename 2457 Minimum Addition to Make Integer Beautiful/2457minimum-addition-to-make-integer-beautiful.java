class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        ArrayList<Integer> digits = new ArrayList<>();
        int sum = 0;
        while(n > 0){
            int val = (int) (n%10);
            digits.add(val);
            sum += val;
            n = n/10;
        }

        if(sum <= target) return 0;
        int ind = 0;
        long mul = 1;
        long cal = 0;
        while(ind < digits.size() && sum > target){
            sum -= digits.get(ind);
            int i = ind+1;
            while(i < digits.size() && digits.get(i) == 9){
                sum -= digits.get(i);
                digits.set(i, 0);
                i++;
            }
            if(i < digits.size()) digits.set(i, digits.get(i) + 1);
            sum += 1;
            int diff = 10 - digits.get(ind);
            cal += (mul*diff);
            digits.set(ind, 0);
            ind++;
            mul *= 10;
        }

        return cal;
    }
}