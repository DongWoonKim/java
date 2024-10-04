package com.example.tobi.springbootbasicboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/")
    public String boardList() {
        return "board-list";
    }

}
