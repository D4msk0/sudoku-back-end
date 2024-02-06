package com.damsko.sudokubackend.controller;

import com.damsko.sudokubackend.model.SudokuModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SudokuControllerTest {

    @InjectMocks
    SudokuController sudokuController;

    @Mock
    Model model;

    @Test
    void sudokuPage() {
        // Arrange
        SudokuModel expectedSudokuModel = new SudokuModel();
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
        expectedSudokuModel.setGrid(initialGrid);

        // Act
        String viewName = sudokuController.sudokuPage(model);

        // Assert
        verify(model).addAttribute(eq("sudokuModel"), any(SudokuModel.class));
        assert viewName != null && viewName.equals("Sudoku");
    }
}
