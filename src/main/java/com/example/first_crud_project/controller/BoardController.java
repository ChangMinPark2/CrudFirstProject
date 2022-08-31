package com.example.first_crud_project.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    private final BoardController boardController;

    public BoardController(BoardController boardController) {
        this.boardController = boardController;
    }


    @DeleteMapping
    public void delete(){

    }

}
