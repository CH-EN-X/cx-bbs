package com.cx.article.controller;

import com.cx.article.service.QuestionsService;
import com.cx.model.article.dtos.AnswerDto;
import com.cx.model.article.dtos.QuestionDto;
import com.cx.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionsService questionService;


    @PostMapping("/add")
    public ResponseResult add(@RequestBody QuestionDto questionDto){
        return questionService.add(questionDto);
    }

    @GetMapping("/waiting")
    public ResponseResult waiting(){
        return questionService.waiting();
    }

    @PostMapping("/waiting")
    public ResponseResult write(@RequestBody AnswerDto dto){
        return questionService.write(dto);
    }

}
