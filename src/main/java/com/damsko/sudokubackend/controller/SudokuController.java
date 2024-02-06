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
        //Should I minimize logic here? Maybe init the grid somewhere else?
        //set initial grid
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
        // Add the Sudoku model to the model to make it available in the view
        model.addAttribute("sudokuModel", sudokuModel);

        // Return the name of the HTML template
        return "Sudoku";
    }
}
