package com.fourward.urcoach.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@ToString
@Table(name = "diary")
public class Diary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "diary_date") private String diaryDate;
    @Column(name = "diary_photo") private String diaryPhoto;
    @Column(name = "diary_days") private String diaryDays;
    @Column(name = "diary_goal") private String diaryGoal;
    @Column(name = "diary_fat") private String diaryFat;
    @Column(name = "diary_water") private String diaryWater;
    @Column(name = "diary_muscle") private String diaryMuscle;
    @Column(name = "diary_skeletal") private String diarySkeletal;
    @Column(name = "diary_comment") private String diaryComment;

    @Builder
    private Diary(String diaryDate, String diaryPhoto, String diaryDays, 
                    String diaryGoal, String diaryFat, String diaryWater,
                    String diaryMuscle, String diarySkeletal, String diaryComment){
        this.diaryDate = diaryDate;
        this.diaryPhoto = diaryPhoto;
        this.diaryDays = diaryDays;
        this.diaryGoal = diaryGoal;
        this.diaryFat = diaryFat;
        this.diaryWater = diaryWater;
        this.diaryMuscle = diaryMuscle;
        this.diarySkeletal = diarySkeletal;
        this.diaryComment = diaryComment;
    }
}