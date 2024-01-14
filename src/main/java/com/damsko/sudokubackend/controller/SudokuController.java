package com.damsko.sudokubackend.controller;

import com.damsko.sudokubackend.model.SudokuModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SudokuController {

    @GetMapping("/sudoku")
    public String sudokuPage(Model model){
        //initialize SudokuModel
        SudokuModel sudokuModel = new SudokuModel();

        //set initial grid
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
        // Add the Sudokumodel to the model to make it available in the view
        model.addAttribute("sudokuModel", sudokuModel);

        // Return the name of the HTML template
        return "Sudoku";
    }
}
