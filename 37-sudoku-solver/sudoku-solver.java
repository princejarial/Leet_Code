class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // empty cell mila
                if (board[row][col] == '.') {

                    // try digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // recursion
                            if (solve(board)) {
                                return true;
                            }

                            // backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // koi number fit nahi hua
                }
            }
        }
        return true; // board solve ho gaya
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        // row check
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num)
                return false;
        }

        // column check
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num)
                return false;
        }

        // 3x3 box check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == num)
                    return false;
            }
        }

        return true;
    }
}
