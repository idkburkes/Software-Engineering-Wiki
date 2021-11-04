

class GameOfLife {


    /**
     * In-place solution
     * 
     * Iterate through entire board checking original state of neighbors
     * Use the absolute value of a cell to determine if the original state was alive
     * Use given rules to determine if cell changes to new state
     * 
     * When a cell dies it's value changes to -1
     * When a cell comes to life its val changes to 2
     * 
     * Iterate through the board a second time to change all values -1 -> 0 and 2 -> 1
     * 
     * @param board
     */
    public void gameOfLife(int[][] board) {
        
        // Neighbor index arrays
        int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0};
        int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1};

        // Board dimensions - M X N
        int rows = board.length;
        int cols = board[0].length;

        // Iterate through board cell by cell
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {

                // Keep track of live neighbors
                int liveCount = 0;

                // Check 8 neighbors of current cell
                for(int shift = 0; shift < 8; shift++) {

                    // Validate neighbor is inbounds
                    if(col + dy[shift] >= 0 && col + dy[shift] < cols 
                        && row + dx[shift] >= 0 && row + dx[shift] < rows) {

                             // Increment liveCount if original val of neighbor is alive
                            if(Math.abs(board[row + dx[shift]][col + dy[shift]]) == 1) {
                                liveCount++;
                            }
                    }
                }

                //Change value of current cell based on amount of live neighbors

                // Rule 1 & 3 - live cell dies
                // When a cell dies it's value changes to -1
                if((liveCount < 2 || liveCount > 3) && board[row][col] == 1) {
                    board[row][col] = -1;
                }

                // Rule 4 dead cell comes to life
                // When a cell comes to life its val changes to 2
                if(liveCount == 3 && board[row][col] == 0) {
                    board[row][col] = 2;
                }


            }
        }

        // Iterate through matrix to change all -1 -> 0 and change all 2 -> 1
            for(int row = 0; row < rows; row++) {
                for(int col = 0; col < cols; col++) {
                    if(board[row][col] == -1) {
                        board[row][col] = 0;
                    } else if(board[row][col] == 2) {
                        board[row][col] = 1;
                    }
                }
            }

    }

    /**
     * Infinite Board Solution Strategy
     * 
     * If the board is infinite, then we won't have enough memory to store the values as a matrix
     * We also won't be able to iterate the entire board (our in-place solution requires iterating twice)
     * 
     * 
     * @param board
     */
    public void gameOfLifeInfinite(int[][] board) {


    }



}