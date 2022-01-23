package com.basic.board.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping({"/", "/board"})
    public String mainForm() {

        return "/board.html";
    }

    @GetMapping("/board/{id}")
    public String detailForm(@PathVariable("id") Integer id, Model model){

        model.addAttribute("id",id);
        return "detail";
    }

    @GetMapping("/board-post")
    public String postForm(){

        return "post";
    }

}
