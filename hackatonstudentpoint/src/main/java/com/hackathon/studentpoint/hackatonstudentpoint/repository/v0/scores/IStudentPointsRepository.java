package com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores;

import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;

public interface IStudentPointsRepository {

    StudentPointDTO getStudentPointById(int id);

}
