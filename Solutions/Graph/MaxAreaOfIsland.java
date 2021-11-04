import java.util.Queue;
import java.util.LinkedList;




/**
 * 
 * Solution Pattern: BFS
 * 
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * 
 * 
 */





class MaxAreaOfIsland {


    public static void main(String[] args) {

        int[][] grid = { {1,1}  };
        System.out.print(maxAreaOfIsland(grid));


    }




    public static int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        int curArea = 0;

        // Store nodes of current island
        Queue<Integer> Q = new LinkedList<>();
        
        // Dimensions of grid
        int rows = grid.length;
        int cols = grid[0].length;
        
        
        // Iterate all nodes on grid
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                    
                // Determine if current node is root of island
                int root = r * cols + c;
                if(grid[r][c] == 1) {
                    grid[r][c] = 0;
                    Q.offer(root);
                    curArea = 1;
                }
                
                // BFS on all neighboring grids
                while(!Q.isEmpty()) {
                
                   int cur = Q.poll();             
                   int row = cur / cols;
                   int col = cur % cols;
                    
                   // Check up
                    if(row - 1 >= 0 && row - 1 < rows 
                      && col >= 0 && col < cols && grid[row - 1][col] == 1) {
                        Q.offer((row - 1) * cols + col);
                        grid[row - 1][col] = 0;
                        curArea++;
                    }
                   // Check down
                    if(row + 1 >= 0 && row + 1 < rows
                      && col >= 0 && col < cols && grid[row + 1][col] == 1) {
                        Q.offer((row + 1) * cols + col);
                        grid[row + 1][col] = 0;
                        curArea++;
                    }
                   // Check left
                    if(row >= 0 && row < rows && col - 1 >= 0 
                       && col - 1 < cols && grid[row][col - 1] == 1) {
                        Q.offer(row * cols + (col - 1));
                        grid[row][col - 1] = 0;
                        curArea++;
                    }
                  // Check right
                    if(row >= 0 && row < rows && col + 1 >= 0
                       && col + 1 < cols && grid[row][col + 1] == 1) {
                        Q.offer(row * cols + (col + 1));
                        grid[row][col + 1] = 0;
                        curArea++;
                    } 
                    
                }
                
                // Check if current area is the new largest and reset current area
                maxArea = Math.max(curArea, maxArea);
                curArea = 0;
                
            }
        }
        
        
        return maxArea;
    }



}