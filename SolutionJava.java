public class SolutionJava {

    public static void main(String[] args) {


        int[][] matrix = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15},
        };

        int[][] matrix2 = {
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}
        };


        System.out.println(maxMoves(matrix));
        System.out.println(maxMoves(matrix2));
    }

    /*
                problem description.

                  matrix 1 :
                          2   3   4   5
                          5   4   9   3
                          3   4   2   11
                          10   9  13   15

                  matrix 2 :
                          3   2   4
                          2   1   9
                          1   1   7


                From a cell (row, col), you can move to any of the cells:
                (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1)
                such that the value of the cell you move to,
                should be strictly bigger than the value of the current cell.

                Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
                Output: 3
                Explanation: We can start at the cell (0, 0) and make the following moves:
                - (0, 0) -> (0, 1).
                - (0, 1) -> (1, 2).
                - (1, 2) -> (2, 3).
                It can be shown that it is the maximum number of moves that can be made.


     */
    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        /*
        Intuition :
                    At each and every step we should always go to the next column but for rows we have 3 options.
                    it is similar to the chess moves of a pawn
                    1)diagonal top
                    2)diagonal down
                    3) right

         */
        /*
        Approach :
                    We should always start from the first column if there is no path in the first column then
                    we simply return 0 as our result.
                   -> we will use the max function to find maximum path at each and every cell.
                   "As we go down I will explain each and every line of the code I'd written"
         */

        /*
        Time complexity : O(m*n) in the worst case as if we found that  first element had path until to the last element in the matrix
        Space complexity : O(1) the below code is not using any extra input arrays or lists.
         */
        int maxMoves = 0;
        /*
                    first we initialize our maximum moves here
                    it is classical approach of finding maximum values in a loop
         */

        // Iterate through each cell in the first column
        for (int i = 0; i < m; i++) {

            /*
            for better readablilty I'd created these variables
            row, column defines the matrix cell position we are iterating
            moves is used for the max function
             */
            int row = i;
            int col = 0;
            int moves = 0;

            /*
            we iterate through the column such that it should never cross the maximum column length.
            so the condition will be col < n-1 (n = column length,  [m][n] matrix)
             */
            while (col < n - 1) {
                int currentVal = grid[row][col];
                // current value in the each iteration
                boolean foundPath = false;
                /*
                this boolean variable is key factor for iterating through the array .
                we will declare this to true only if we found the path otherwise this will
                break the loop and help us to move to the next cell.
                 */


                /*
                  Check the three possible moves
                  at each and every step we are needed to move to the next column as per the condition
                  So we will go from row-1 , row , row+1 at each cell .
                  the below for loop exactly does that
                 */
                for (int newRow = row - 1; newRow <= row + 1; newRow++) {
                    if (newRow >= 0 && newRow < m && grid[newRow][col + 1] > currentVal) {
                        /*
                        if we found the path then we
                        initialize our row to the newRow we found and normally the column should be incremented
                         */

                        row = newRow;
                        col++;
                        foundPath = true;
                        break;
                    }
                }

                if (!foundPath) {
                    /*
                    if we didn't find any possible move then we break the loop here itself and
                    move the next element in the column
                     */
                    break;
                }

                moves++;
                // we found a path now so increment moves by 1
            }

            maxMoves = Math.max(maxMoves, moves);
            /*
            classical approach of finding the maximum value .
            this simple max function helps us to avoid creation of new array or list.
             */
        }

        return maxMoves;
        /*
        simply we return our answer.
         */
    }


}
