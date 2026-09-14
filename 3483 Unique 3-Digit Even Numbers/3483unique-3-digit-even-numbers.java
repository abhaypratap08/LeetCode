class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet();
        for(int i = 0; i < digits.length; i++){
            for(int j = 0; j < digits.length; j++){
                if(j != i){
                    for(int k = 0; k < digits.length; k++){

                        if(k != j && k != i && digits[i] != 0 && digits[k] % 2 == 0){
                            int digit = (digits[i]*100)+(digits[j]*10)+digits[k];
                            set.add(digit);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}