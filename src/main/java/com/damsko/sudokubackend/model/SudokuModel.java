package com.damsko.sudokubackend.model;

public class SudokuModel {
    private int[][] grid;

    public Sudoku() {
        // Initialize the grid, you can set initial values or keep them all as 0
    }

    public void setGrid(int[][] grid) {
        // Set the grid with a provided 2D array
    }

    public int[][] getGrid() {
        // Get the current state of the grid
    }

    public boolean isValidMove(int row, int col, int value) {
        // Check if placing 'value' in the specified row and column is a valid move
    }

    public boolean isSolved() {
        // Check if the Sudoku puzzle is solved
    }

    public boolean solve() {
        // Attempt to solve the Sudoku puzzle
    }
}
