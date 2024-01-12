package com.damsko.sudokubackend.model;

public class SudokuModel {
    private int[][] grid;

    public SudokuModel() {
        this.grid = new int[9][9];
        // Initialize the grid with zeros
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                this.grid[i][j] = 0;
//            }
//        }
    }

    public void setGrid(int[][] grid) {
        // Set the grid with a provided 2D array
        this.grid = grid;
    }

    public int[][] getGrid() {
        // Get the current state of the grid
        return this.grid;
    }

    public boolean isValidMove(int row, int col, int value) {
        // Check if placing 'value' in the specified row and column is a valid move

        // Check the row and column
        for (int i = 0; i < 9; i++) {
            if (this.grid[row][i] == value || this.grid[i][col] == value) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int subgridRowStart = 3 * (row / 3);
        int subgridColStart = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grid[subgridRowStart + i][subgridColStart + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSolved() {
        // Check if the Sudoku puzzle is solved

        // Check if there are any zeros in the grid
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.grid[i][j] == 0) {
                    return false;
                }
            }
        }

        // Check if each row, column, and 3x3 subgrid contains all numbers from 1 to 9
        for (int i = 0; i < 9; i++) {
            if (!isValidSet(this.grid[i]) || !isValidSet(getColumn(i))) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSet(getSubgrid(i, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve() {
        // Attempt to solve the Sudoku puzzle
        return solveSudoku();
    }

    private boolean solveSudoku() {
        // Implementation of the Sudoku solving algorithm (backtracking)

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (this.grid[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidMove(row, col, num)) {
                            this.grid[row][col] = num;

                            if (solveSudoku()) {
                                return true;
                            }

                            this.grid[row][col] = 0; // Backtrack if the current move doesn't lead to a solution
                        }
                    }

                    return false; // No valid number for the current cell
                }
            }
        }

        return true; // All cells filled, puzzle solved
    }

    private boolean isValidSet(int[] array) {
        // Check if the array contains all numbers from 1 to 9
        boolean[] used = new boolean[9];

        for (int num : array) {
            if (num < 1 || num > 9 || used[num - 1]) {
                return false;
            }

            used[num - 1] = true;
        }

        return true;
    }

    private int[] getColumn(int col) {
        // Get a column from the grid
        int[] column = new int[9];
        for (int i = 0; i < 9; i++) {
            column[i] = this.grid[i][col];
        }
        return column;
    }

    private int[] getSubgrid(int rowStart, int colStart) {
        // Get a 3x3 subgrid from the grid
        int[] subgrid = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subgrid[index++] = this.grid[rowStart + i][colStart + j];
            }
        }
        return subgrid;
    }
}

