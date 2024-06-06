package com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores;

import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.data.StudentScore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IStudentScoreFacade {

    @GetMapping("/{idStudent}")
    ResponseEntity<StudentScore> getStudentPointById(@PathVariable(name = "idStudent") int id);
}
