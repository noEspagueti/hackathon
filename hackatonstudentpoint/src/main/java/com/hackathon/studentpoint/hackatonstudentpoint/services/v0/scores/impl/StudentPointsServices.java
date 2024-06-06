package com.hackathon.studentpoint.hackatonstudentpoint.services.v0.scores.impl;

import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.IStudentPointsRepository;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;
import com.hackathon.studentpoint.hackatonstudentpoint.services.v0.scores.IStudentPointsServices;
import org.springframework.stereotype.Service;

@Service
public class StudentPointsServices implements IStudentPointsServices {

    private IStudentPointsRepository studentPointsRepository;

    public StudentPointsServices(IStudentPointsRepository studentPointsRepository) {
        this.studentPointsRepository = studentPointsRepository;
    }

    @Override
    public StudentPointDTO getStudentPointById(int id) {
        return studentPointsRepository.getStudentPointById(id);
    }

    @Override
    public void createStudentPoint(StudentPointDTO studentPointDTO) {
        studentPointsRepository.createStudentPointById(studentPointDTO);
    }

    @Override
    public int updateScore(int id, int points) {
        return studentPointsRepository.updateScore(id, points);
    }


}
