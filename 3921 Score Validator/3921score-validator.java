class Solution {
    public int[] scoreValidator(String[] events) {
        int counter = 0;
        int score = 0;
        
        for(String i : events){
            if (counter == 10) {
                break;
            }
            if (i.equals("WD")) {
                score += 1;
            } 
            else if (i.equals("NB")) {
                score += 1;
            } 
            else if (i.equals("W")) {
                counter += 1;
            } 
            else {
                score += Integer.parseInt(i);
            }
        }

        return new int[]{score, counter};
    }
}
