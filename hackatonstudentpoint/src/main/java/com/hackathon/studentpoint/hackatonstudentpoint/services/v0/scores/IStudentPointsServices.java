package com.hackathon.studentpoint.hackatonstudentpoint.services.v0.scores;

import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;

public interface IStudentPointsServices {

    StudentPointDTO getStudentPointById(int id);

    void createStudentPoint(StudentPointDTO studentPointDTO);
    int updateScore(int id, int points);
}
