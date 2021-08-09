package Solutions.Graph;


/**
 *  You are given row x col grid representing a map where grid[i][j] = 1 represents land and
 *  grid[i][j] = 0 represents water.
 * 
 *  Grid cells are connected horizontally/vertically (not diagonally). The grid is completely
 * surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * 
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the
 * island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed
 * 100. Determine the perimeter of the island.
 * 
 * The solution pattern to solve this graph problem is Depth-First Search. I created an auxilliary matrix
 * to keep track of the visited grid squares. I iterated over each grid until I found the first grid that
 * is marked as "land". From there I performed a recursive call to count the free edges on each grid that was
 * connected. If the neighbor edge was water I added 1 to the total count.
 *  After visiting each grid i marked them as visited in the auxilliary array.
 *  
 */
class IslandPerimeter {

 
    public static int getPerimeter(int[][] grid, boolean[][]visited, int row, int col){
        //Boundary conditions. Return 1 since it is water
        if(row < 0 || row >= grid.length || col >= grid[0].length || col < 0) return 1; 

        //If this grid is water then add 1 edge
        if(grid[row][col] == 0) return 1;

        //If this grid already visited return 0
        if(visited[row][col] == true) return 0;

        //Set grid visited
        visited[row][col] = true;

       int perimeter = 0;

        //Recursive call on all neighbors
        perimeter = getPerimeter(grid, visited, row + 1, col)
         + getPerimeter(grid, visited, row - 1, col)
         + getPerimeter(grid, visited, row, col + 1)
         + getPerimeter(grid, visited, row, col - 1);

         return perimeter;
    }


    public int islandPerimeter(int[][] grid) {
        //base case
        if(grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
            //Find first grid that has land and use BFS to count perimeter
            for(int row = 0; row < grid.length; row++) {
                for(int col = 0; col < grid[0].length; col++) {
                    if(grid[row][col] == 1) {
                        return getPerimeter(grid, visited, row, col);
                    }
                }
            }
    return 0;  //If no land found return 0
    }

}