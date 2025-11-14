class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) 
    {
        int[][] matrix = new int[n][n];
        for (int[] query : queries) 
        {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
        
            matrix[row1][col1]++;
            if (row2 + 1 < n) 
            {
                matrix[row2 + 1][col1]--;
            }
            if (col2 + 1 < n) 
            {
                matrix[row1][col2 + 1]--;
            }
            if (row2 + 1 < n && col2 + 1 < n) 
            {
                matrix[row2 + 1][col2 + 1]++;
            }
        }
        for (int row = 0; row < n; row++) 
        {
            for (int col = 0; col < n; col++) 
            {
                if (row > 0) 
                {
                    matrix[row][col] += matrix[row - 1][col];
                }
                if (col > 0) 
                {
                    matrix[row][col] += matrix[row][col - 1];
                }
                if (row > 0 && col > 0) 
                {
                    matrix[row][col] -= matrix[row - 1][col - 1];
                }
            }
        }      
        return matrix;
    }
}
