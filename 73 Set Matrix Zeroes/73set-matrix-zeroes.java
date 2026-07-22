class Solution {
    public void setZeroes(int[][] matrix) {
        List<Pair<Integer, Integer>> Coords = new ArrayList<Pair<Integer, Integer>>();
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    Pair<Integer, Integer> val = new Pair<Integer, Integer>(i, j);
                    Coords.add(val);
                }
            }
        }
        for (Pair<Integer, Integer> coord : Coords) {
            int y = coord.getKey();
            int x = coord.getValue();
            for (int i=0;i<matrix.length;i++) {
                matrix[i][x] = 0;
            }
            for (int i=0;i<matrix[0].length;i++) {
                matrix[y][i] = 0;
            }
        }
    }
}