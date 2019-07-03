package com.fourward.urcoach.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @GetMapping("/exists/{diaryDate}")
    public boolean existsByDiaryDate(@PathVariable String diaryDate){
        System.out.println("exists() 진입 : " + diaryDate);
        return false;
    }
}