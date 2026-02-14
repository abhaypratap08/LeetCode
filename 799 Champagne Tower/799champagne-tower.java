class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // We start with all the liquid in the single glass at the top (row 0)
        double[] currentRow = new double[1];
        currentRow[0] = poured;
        
        for (int r = 0; r <= query_row; ++r) { 
            // The next row always has one more glass than the current row
            double[] nextRow = new double[r + 2]; 
            boolean anyOverflow = false;

            for (int c = 0; c <= r; ++c) { 
                // If the glass has more than 1 unit, it overflows
                if (currentRow[c] > 1.0) { 
                    double excess = currentRow[c] - 1.0;
                    double splitFlow = excess / 2.0;
                    
                    nextRow[c] += splitFlow; 
                    nextRow[c + 1] += splitFlow; 
                    
                    currentRow[c] = 1.0; // The glass remains full
                    anyOverflow = true;
                }
            }
            
            // Optimization: If no glass in this row overflowed, 
            // rows below will stay empty.
            if (!anyOverflow && r < query_row) {
                return (r == query_row) ? currentRow[query_glass] : 0.0;
            }

            if (r != query_row) {
                currentRow = nextRow; 
            }
        }
        
        return currentRow[query_glass];
    }
}