package com.damsko.sudokubackend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuModelTest {
    @Test
    void testInitialization() {
        SudokuModel sudokuModel = new SudokuModel();
        int[][] grid = sudokuModel.getGrid();

        // Check if the grid is initialized with zeros
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(0, grid[i][j]);
            }
        }
    }

    @Test
    void testSetAndGetGrid() {
        SudokuModel sudokuModel = new SudokuModel();
        int[][] newGrid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudokuModel.setGrid(newGrid);
        int[][] retrievedGrid = sudokuModel.getGrid();

        // Check if set and get grid work correctly
        assertArrayEquals(newGrid, retrievedGrid);
    }

    @Test
    void testIsValidMove() {
        final SudokuModel sudokuModel = getSudokuModel();

        // Check valid moves in the initial grid
        assertTrue(sudokuModel.isValidMove(0, 2, 1));
        assertTrue(sudokuModel.isValidMove(2, 5, 2));
        assertTrue(sudokuModel.isValidMove(8, 6, 3));

        // Check invalid moves in the initial grid
        assertFalse(sudokuModel.isValidMove(0, 2, 6));
        assertFalse(sudokuModel.isValidMove(2, 5, 8));
        assertFalse(sudokuModel.isValidMove(8, 8, 9));
    }

    private static SudokuModel getSudokuModel() {
        SudokuModel sudokuModel = new SudokuModel();
        int[][] initialGrid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudokuModel.setGrid(initialGrid);
        return sudokuModel;
    }

    @Test
    void testIsSolved() {
        SudokuModel sudokuModel = new SudokuModel();
        int[][] solvedGrid = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        sudokuModel.setGrid(solvedGrid);

        // Check if the solved grid is recognized as solved
        assertTrue(sudokuModel.isSolved());

        int[][] unsolvedGrid = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 0} // Last cell is not filled
        };

        sudokuModel.setGrid(unsolvedGrid);

        // Check if the unsolved grid is recognized as not solved
        assertFalse(sudokuModel.isSolved());
    }

    @Test
    void testSolve() {
        SudokuModel sudokuModel = new SudokuModel();
        int[][] unsolvedGrid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudokuModel.setGrid(unsolvedGrid);

        // Attempt to solve the unsolved grid
        assertTrue(sudokuModel.solve());

        // Check if the grid is now solved
        assertTrue(sudokuModel.isSolved());
    }
}
