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
        configParams.addValue("idStudentPoint", id);
        return namedParameterJdbcTemplate.queryForObject(
                query,
                configParams,
                new StudentPointMapper());
    }

}
