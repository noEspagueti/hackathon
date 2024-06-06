package com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores;

import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.data.StudentScore;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

public interface IStudentScoreFacade {

    @GetMapping("/{idStudent}")
    ResponseEntity<StudentScore> getStudentPointById(@PathVariable(name = "idStudent") int id);

    @PostMapping("/create")
    ResponseEntity<String> createStudentScore(@Valid @RequestBody StudentScore studentPointDTO, BindingResult bindingResult);

    @PatchMapping("/updatescore/{idStudent}")
    ResponseEntity<String> updatePointsPerStudent(@PathVariable(name = "idStudent") int id, @RequestBody StudentScore studentPointDTO);
}
