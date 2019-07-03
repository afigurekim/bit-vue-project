package com.fourward.urcoach.repositories;

import com.fourward.urcoach.entities.Diary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends CrudRepository<Diary, Long> {
    public boolean existsByDiaryDate(String diaryDate);
    public Diary findByDiaryDate(String diaryDate);

    @Query(value = "INSERT INTO DIARY (diary_date,diary_days,diary_goal,diary_fat,diary_water,diary_muscle,diary_skeletal,diary_comment) VALUES (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    public void insertOneDiary(
        String diaryDate, 
        String diaryDays, 
        String diaryGoal, 
        String diaryFat, 
        String diaryWater, 
        String diaryMuscle, 
        String diarySkeletal, 
        String diaryComment
    );
}