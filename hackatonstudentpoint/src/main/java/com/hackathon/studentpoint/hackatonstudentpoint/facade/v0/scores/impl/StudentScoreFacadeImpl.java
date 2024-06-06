package com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.impl;

import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.IStudentScoreFacade;
import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.data.StudentScore;
import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.mapper.StudentScoreMapper;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;
import com.hackathon.studentpoint.hackatonstudentpoint.services.v0.scores.IStudentPointsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v0/scores")
public class StudentScoreFacadeImpl implements IStudentScoreFacade {

    private IStudentPointsServices studentPointsServices;
    private Validator studentScoreValidator;

    public StudentScoreFacadeImpl(IStudentPointsServices studentPointsServices, Validator studentScoreValidator) {
        this.studentPointsServices = studentPointsServices;
        this.studentScoreValidator = studentScoreValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(studentScoreValidator);
    }

    @Override
    public ResponseEntity<StudentScore> getStudentPointById(int id) {
        StudentPointDTO studentPointDTO = studentPointsServices.getStudentPointById(id);
        StudentScore studentScore = StudentScoreMapper.studentPintDTOToStudentScore(studentPointDTO);
        return new ResponseEntity<>(studentScore, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createStudentScore(StudentScore studentScore, BindingResult bindingResult) {
        StudentPointDTO studentPointDTO = StudentScoreMapper.studentScoreTostudentPintDTO(studentScore);
        studentPointsServices.createStudentPoint(studentPointDTO);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error de validación: " + bindingResult.getAllErrors());
        }
        return ResponseEntity.ok("[SUCCESS] {" + studentPointDTO.toString() + "}");
    }

    @Override
    public ResponseEntity<String> updatePointsPerStudent(int id, StudentScore studentPointDTO) {
        int scores = studentPointDTO.getPoints();
        int result = studentPointsServices.updateScore(studentPointDTO.getId(), scores);
        if (result == 0) {
            return ResponseEntity.badRequest().body("[ERROR][Has ocurred an error]");
        }
        return ResponseEntity.ok("[SUCCESS UPDATE] {" + studentPointDTO.toString() + "}");
    }


}
