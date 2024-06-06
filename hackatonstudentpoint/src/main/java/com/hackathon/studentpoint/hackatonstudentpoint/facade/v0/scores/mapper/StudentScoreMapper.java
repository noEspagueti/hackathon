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

}
