package com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.impl;

import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.IStudentPointsRepository;

import static com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.Utils.Constant.*;

import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.mapper.StudentPointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StudentPointsRepositoryImpl implements IStudentPointsRepository {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public StudentPointsRepositoryImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public StudentPointDTO getStudentPointById(int id) {
        String query = CONSULT + TABLE_DB_NAME + PER_ID;
        MapSqlParameterSource configParams = new MapSqlParameterSource();
        configParams.addValue(ID, id);
        return namedParameterJdbcTemplate.queryForObject(
                query,
                configParams,
                new StudentPointMapper());
    }

    @Override
    public void createStudentPointById(StudentPointDTO studentPointDTO) {
        String query = INGESTION + TABLE_DB_NAME + FIELD_CREATE_FULL;
        MapSqlParameterSource configParams = new MapSqlParameterSource();
        configParams.addValue(ID, studentPointDTO.getId());
        configParams.addValue(STUDENT_CODE, studentPointDTO.getStudenCode());
        configParams.addValue(POINTS, studentPointDTO.getPoints());
        configParams.addValue(TYPE, String.valueOf(studentPointDTO.getType()));
        configParams.addValue(DAY_ID, studentPointDTO.getDayId());
        namedParameterJdbcTemplate.update(query, configParams);
    }

    @Override
    public int updateScore(int id, int points) {
        String query = UPDATE + TABLE_DB_NAME + UPDATE_FIELDS + PER_ID;
        MapSqlParameterSource configParams = new MapSqlParameterSource();
        configParams.addValue(ID, id);
        configParams.addValue(POINTS, points);
        return namedParameterJdbcTemplate.update(query, configParams);
    }

}
