package com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.mapper;

import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.data.StudentScore;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;

public final class StudentScoreMapper {

    private StudentScoreMapper() {
    }

    public static StudentScore studentPintDTOToStudentScore(StudentPointDTO studentPointDTO) {
        StudentScore studentScore = new StudentScore();
        studentScore.setId(studentPointDTO.getId());
        studentScore.setStudenCode(studentPointDTO.getStudenCode());
        studentScore.setType(studentPointDTO.getType());
        studentScore.setPoints(studentPointDTO.getPoints());
        studentScore.setDayId(studentPointDTO.getDayId());
        return studentScore;
    }

    public static StudentPointDTO studentScoreTostudentPintDTO(StudentScore studentScore) {
        StudentPointDTO studentPointDTO = new StudentPointDTO();
        studentPointDTO.setId(studentScore.getId());
        studentPointDTO.setStudenCode(studentScore.getStudenCode());
        studentPointDTO.setType(studentScore.getType());
        studentPointDTO.setPoints(studentScore.getPoints());
        studentPointDTO.setDayId(studentScore.getDayId());
        return studentPointDTO;
    }
}
