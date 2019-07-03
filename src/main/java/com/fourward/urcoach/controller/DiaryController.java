package com.fourward.urcoach.controller;

import com.fourward.urcoach.domain.DiaryDTO;
import com.fourward.urcoach.repositories.DiaryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Autowired DiaryDTO dto;
    @Autowired DiaryRepository repo;
    @Autowired ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @GetMapping("/exists/{diaryDate}")
    public String existsByDiaryDate(@PathVariable String diaryDate){
        System.out.println("* exists() 진입: " + diaryDate);
        String p = "DayNew";
        if(repo.existsByDiaryDate(diaryDate)){
            p = "DayView";
        };
        System.out.println("* exists() return value: " + p);
        return p;
    }

    @GetMapping("/find/{diaryDate}")
    public DiaryDTO findByDiaryDate(@PathVariable String diaryDate) {
        System.out.println("* findBy() 진입: " + diaryDate);
        return modelMapper.map(repo.findByDiaryDate(diaryDate), DiaryDTO.class);
    }

    @PostMapping("")
    public void insertOneDiary(@RequestBody DiaryDTO dto){
        System.out.println("* insertOne() 진입: " + dto.getDiaryDate());
        repo.insertOneDiary(
            dto.getDiaryDate(),
            dto.getDiaryDays(),
            dto.getDiaryGoal(),
            dto.getDiaryFat(),
            dto.getDiaryWater(),
            dto.getDiaryMuscle(),
            dto.getDiarySkeletal(),
            dto.getDiaryComment()
        );
        System.out.println("* insertOne() 실행 완료");
    }
}