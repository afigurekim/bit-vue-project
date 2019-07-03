package com.fourward.urcoach.repositories;

import com.fourward.urcoach.entities.Diary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends CrudRepository<Diary, Long> {
    public Diary findByDiaryDateNotNull(String diaryDate);
}