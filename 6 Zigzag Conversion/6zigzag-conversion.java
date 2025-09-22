class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        List<List<Character>> mat = new ArrayList<>();
        for(int r = 0;r<numRows;r++)
        {
            mat.add(new ArrayList<>());
        }
        int i = 0;
        while(i<n)
        {
            for(int d = 0;d<numRows && i<n;d++)
            {
                mat.get(d).add(s.charAt(i++));
            }
            for(int up = numRows-2;up>0  && i<n;up--)
            {
                mat.get(up).add(s.charAt(i++));
            }
        }
        String ans = "";
        for(i=0;i<numRows;i++)
        {
            for(int j=0;j<mat.get(i).size();j++)
            ans += mat.get(i).get(j);
        }
        return ans;
    }
}