package com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.mapper;

import static com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.Utils.Constant.*;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentPointMapper implements RowMapper<StudentPointDTO> {

    @Override
    public StudentPointDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentPointDTO studentPointDTO = new StudentPointDTO();
        studentPointDTO.setId(rs.getInt(FIELD_ID));
        studentPointDTO.setStudenCode(rs.getString(FIELD_STUDENT_CODE));
        studentPointDTO.setType(rs.getString(FIELD_TYPE).charAt(0));
        studentPointDTO.setDayId(rs.getInt(FIELD_DAY_ID));
        studentPointDTO.setPoints(rs.getInt(FIELD_POINTS));
        return studentPointDTO;
    }

}
