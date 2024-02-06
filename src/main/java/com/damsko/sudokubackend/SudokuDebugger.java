package com.damsko.sudokubackend;

import com.damsko.sudokubackend.model.SudokuModel;

public class SudokuDebugger {
    public static void main(String[] args) {
        // Your debugging logic with SudokuModel here
        final SudokuModel sudokuModel = getSudokuModel();

        // Example: Set a value in the grid
        int row = 0;
        int col = 2;
        int value = 1;

        // Check if the move is valid
        if (sudokuModel.isValidMove(row, col, value)) {
            // If valid, set the value
            sudokuModel.getGrid()[row][col] = value;
            System.out.println("Value set successfully:");
            printGrid(sudokuModel.getGrid());
        } else {
            System.out.println("Invalid move. The value cannot be set.");
        }

        // Example: Attempt to solve the Sudoku puzzle
        if (sudokuModel.solve()) {
            System.out.println("Sudoku solved successfully:");
            printGrid(sudokuModel.getGrid());
        } else {
            System.out.println("Unable to solve the Sudoku puzzle.");
        }
    }

    private static SudokuModel getSudokuModel() {
        SudokuModel sudokuModel = new SudokuModel();

        // Set an initial grid (optional)
        int[][] initialGrid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 2, 0, 0, 0, 0, 0, 0}
        };
        sudokuModel.setGrid(initialGrid);
        return sudokuModel;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
