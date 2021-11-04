
import java.util.Queue;
import java.util.LinkedList;

public class NumberOfIslands {

 class NumberOfIslandsDFS {

    public int numIslands(char[][] grid) {
        //Input validation
        if(grid == null || grid.length == 0 ) return 0;
        
        int islandsFound = 0;
        
        //Determine boundaries of grid
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        // Linear scan through grid to find root 'nodes'
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                
            //New root node found
                if(grid[row][col] == '1') {
                    //Perform DFS starting from current node
                    dfs(grid, row, col);
                    
                    //Increment islands found
                    islandsFound++;
                } 
            }
        }
        return islandsFound; 
    }
    
    
    public void dfs(char[][] grid, int row, int col) {
        // Check if current node is within boundaries or already visited
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        if(row < 0 || col < 0 || row >= numRows || col >= numCols
            || grid[row][col] == '0') {
            return;
        }
        
        // Mark the current node as visited
        grid[row][col] = '0';
        
        // Recursive call on all neighbors 
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

}



public class NumberOfIslandsBFS {

    public int numIslands(char[][] grid) {
        
        // Input validation and init return value
        if(grid == null || grid.length == 0) return 0;
        int numIslands = 0;
        
        // Identify boundaries
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        // Linear search through grid 
        for(int r = 0; r < numRows; r++) {
            for(int c = 0; c < numCols; c++) {   
                 // Perform BFS on root nodes
                if(grid[r][c] == '1') {
                  //Mark root node as visited and increment islands found
                int root = r * numCols + c;
                grid[r][c] = '0';
                numIslands++;
                
                //Create Queue with current node
                Queue<Integer> neighbors = new LinkedList<>();
                neighbors.offer(root);
            
                // Check all neighbor nodes for this island 
                while(!neighbors.isEmpty()) {
                    int cur = neighbors.poll();
                    int row = cur / numCols;
                    int col = cur % numCols;
                    
                    // Visit up
                    if(row - 1 >= 0 && grid[row - 1][col] == '1') {
                        grid[row - 1][col] = '0';
                        neighbors.offer( (row - 1) * numCols + col);
                    }
                    
                    // Visit down
                     if(row + 1 < numRows && grid[row + 1][col] == '1') {
                        grid[row + 1][col] = '0';
                        neighbors.offer((row + 1) * numCols + col);
                    }
                    
                    // Visit left
                     if(col - 1 >= 0 && grid[row][col - 1] == '1') {
                        grid[row][col - 1] = '0';
                         neighbors.offer(row * numCols + (col - 1));
                    }
                    
                    // Visit right
                       if(col + 1 < numCols && grid[row][col + 1] == '1') {
                        grid[row][col + 1] = '0';
                        neighbors.offer(row * numCols + (col + 1));
                    }  
                }          
              }
            }
        }
           
        
        return numIslands;
    }


    
}

}