class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions =  new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
            Queue<int[]> rotten = new LinkedList<>();
            int minute = 0 ;
            int total =  0;
            for(int i = 0 ; i < grid.length; i++){
                for(int j = 0 ; j <grid[i].length;j++){
                        if(grid[i][j]==2){
                            rotten.add(new int[]{i,j});
                        }
                        if(grid[i][j]==1){
                            total++;
                        }
                }
            }
            if(total==0){
                return  0 ;
            }
            while(!rotten.isEmpty()){
                int size  = rotten.size();
                for(int i = 0 ; i< size;i++){
                    int[] temp =  rotten.poll();
                    for(int[] dir : directions){
                        int row = temp[0] + dir[0];
                        int col = temp[1] + dir[1];
                        if((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length) && grid[row][col]==1){
                            grid[row][col] = 2;
                            total --;
                            rotten.add(new int[]{row,col});
                        }
                    }
                }
                 minute ++;
                if(total==0){
                    break;
                }
            }
            return total==0? minute:-1;
    }
}