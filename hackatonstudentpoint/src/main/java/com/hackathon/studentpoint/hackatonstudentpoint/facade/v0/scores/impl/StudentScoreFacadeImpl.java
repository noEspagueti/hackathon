package com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.impl;

import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.IStudentScoreFacade;
import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.data.StudentScore;
import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.mapper.StudentScoreMapper;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;
import com.hackathon.studentpoint.hackatonstudentpoint.services.v0.scores.IStudentPointsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v0/scores")
public class StudentScoreFacadeImpl implements IStudentScoreFacade {

    private IStudentPointsServices studentPointsServices;

    public StudentScoreFacadeImpl(IStudentPointsServices studentPointsServices) {
        this.studentPointsServices = studentPointsServices;
    }

    @Override
    public ResponseEntity<StudentScore> getStudentPointById(int id) {
        StudentPointDTO studentPointDTO = studentPointsServices.getStudentPointById(id);
        StudentScore studentScore = StudentScoreMapper.studentPintDTOToStudentScore(studentPointDTO);
        return new ResponseEntity<>(studentScore, HttpStatus.OK);
    }
}
