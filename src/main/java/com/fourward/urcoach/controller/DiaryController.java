package com.fourward.urcoach.controller;

import com.fourward.urcoach.domain.DiaryDTO;
import com.fourward.urcoach.entities.Diary;
import com.fourward.urcoach.repositories.DiaryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


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

    @PostMapping("")
    public void save(@RequestBody DiaryDTO dto){
        System.out.println("* save() 진입: " + dto.getDiaryDate());
        Diary entity = new Diary();
        entity.setDiaryDate(dto.getDiaryDate());
        entity.setDiaryDays(dto.getDiaryDays());
        entity.setDiaryGoal(dto.getDiaryGoal());
        entity.setDiaryFat(dto.getDiaryFat());
        entity.setDiaryWater(dto.getDiaryWater());
        entity.setDiaryMuscle(dto.getDiaryMuscle());
        entity.setDiarySkeletal(dto.getDiarySkeletal());
        entity.setDiaryComment(dto.getDiaryComment());
        repo.save(entity);
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

    @PutMapping("/update/{diaryDate}")
    public void update(@PathVariable String diaryDate, @RequestBody DiaryDTO dto) {
        System.out.println("* update() 진입: " + dto.getDiaryDate());
        Diary entity = repo.findByDiaryDate(diaryDate);
        entity.setDiaryDays(dto.getDiaryDays());
        entity.setDiaryGoal(dto.getDiaryGoal());
        entity.setDiaryFat(dto.getDiaryFat());
        entity.setDiaryWater(dto.getDiaryWater());
        entity.setDiaryMuscle(dto.getDiaryMuscle());
        entity.setDiarySkeletal(dto.getDiarySkeletal());
        entity.setDiaryComment(dto.getDiaryComment());
        repo.save(entity);
    }

    @DeleteMapping("/delete/{diaryDate}")
    public void deleteDiary(@PathVariable String diaryDate) {
        System.out.println("* delete() 진입: " + diaryDate);
        Diary entity = repo.findByDiaryDate(diaryDate);
        repo.delete(entity);
    }
}