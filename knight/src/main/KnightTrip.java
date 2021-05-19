class KnightTrip {
    private int BOARD_SIZE;
    private int[][] visited;
    //8 possible movements
    private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public KnightTrip(int chessBoardSize) {
        this.BOARD_SIZE = chessBoardSize;
        this.visited = new int[BOARD_SIZE][BOARD_SIZE];
        this.processBoard();
    }

    private void processBoard() {
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                this.visited[i][j] = -1; //-ve number
    }

    public void solveKnightProblem() {
        visited[0][0] = 0;
        // start knight's trip at (0, 0) top left
        if( solveProblem(1, 0, 0)) {
            printSolution();
        } else {
            System.out.println("No solution found...");
        }
    }

    public boolean solveProblem(int moveCount, int x, int y) {
        // check we visited each square exactly once
        if (moveCount == BOARD_SIZE * BOARD_SIZE) {
            return true;
        }

        for (int i = 0; i < xMoves.length; ++i) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];

            // check if new position is a valid and not visited yet
            if ( isValidMove(nextX, nextY) && visited[nextX][nextY] == -1) {

                visited[nextX][nextY] = moveCount;
                if ( solveProblem(moveCount + 1, nextX, nextY) ) {
                    return true;
                }

                // BACKTRACK !!!
                visited[nextX][nextY] = -1;
            }
        }
        return false;
    }

    public boolean isValidMove(int x, int y) {
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            return false;
        } else {
            return true;
        }
    }

    public void printSolution() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
