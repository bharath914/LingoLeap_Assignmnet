

**Here is the solution for the given problem in the assignment**

**Time complexity :**  O(m*n) in the worst case.

**Space complexity :** O(1) as we are not using any extra memory.

** Here is the small diagramatic expression I explained each and every line in the code**

![image](https://github.com/bharath914/assignment/assets/98139751/a2b34e5f-1c35-400c-9f78-9f145532c649)


**Code Language : Java**

solution : 
```java

        int m = grid.length;
        int n = grid[0].length;

        int maxMoves = 0;
        for (int i = 0; i < m; i++) {
            int row = i;
            int col = 0;
            int moves = 0;
            while (col < n - 1) {
                int currentVal = grid[row][col];
                boolean foundPath = false;
                for (int newRow = row - 1; newRow <= row + 1; newRow++) {
                    if (newRow >= 0 && newRow < m && grid[newRow][col + 1] > currentVal) {
                        row = newRow;
                        col++;
                        foundPath = true;
                        break;
                    }
                }

                if (!foundPath) {
                    break;
                }
                moves++;
            }

            maxMoves = Math.max(maxMoves, moves);
        }
        return maxMoves



```

#Please also check the source code there I had explained each and every step.
