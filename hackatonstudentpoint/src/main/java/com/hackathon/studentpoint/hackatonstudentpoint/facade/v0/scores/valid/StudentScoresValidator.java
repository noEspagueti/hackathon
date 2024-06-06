package com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.valid;

import com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.data.StudentScore;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StudentScoresValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return StudentScore.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentScore studentScore = (StudentScore) target;
        if (studentScore.getId() != 0) {
            errors.rejectValue("id", "[VALID] Id mal implementado: 0");
        }else if (studentScore.getDayId() == 0) {
            errors.rejectValue("dayId", "[VALID] dayId mal implementado: 0");
        }else if (studentScore.getStudenCode().isBlank() || studentScore.getStudenCode().isEmpty()) {
            errors.rejectValue("studenCode", "[VALID] Student code mal implementado");
        }else if (studentScore.getType() == ' ') {
            errors.rejectValue("type", "[VALID] type code mal implementado");
        }

    }
}
