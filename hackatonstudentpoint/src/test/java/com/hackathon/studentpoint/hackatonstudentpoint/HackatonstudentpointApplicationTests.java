package com.hackathon.studentpoint.hackatonstudentpoint;

import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.IStudentPointsRepository;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.dto.StudentPointDTO;
import com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.mapper.StudentPointMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



@SpringBootTest
class HackatonstudentpointApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IStudentPointsRepository studentPointsRepository;

    @Test
    void testDatabaseConnection_OK() {
        try (Connection connection = dataSource.getConnection()) {
            Assert.assertNotNull(connection);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }


    @Test
    void getResultSet_OK() throws SQLException {

        StudentPointDTO studentPointDTO = new StudentPointDTO();
        studentPointDTO.setId(1);
        studentPointDTO.setStudenCode("abd");
        studentPointDTO.setDayId(1);
        studentPointDTO.setPoints(1000);
        studentPointDTO.setType('I');

        MapSqlParameterSource configParams = new MapSqlParameterSource();
        configParams.addValue("idStudentPoint", 1);

        ResultSet resultSet = Mockito.mock(ResultSet.class);

        Mockito.when(resultSet.next()).thenReturn(true);

        Mockito.when(resultSet.getInt("id")).thenReturn(studentPointDTO.getId());
        Mockito.when(resultSet.getString("student_code")).thenReturn(studentPointDTO.getStudenCode());
        Mockito.when(resultSet.getInt("day_id")).thenReturn(studentPointDTO.getDayId());
        Mockito.when(resultSet.getInt("points")).thenReturn(studentPointDTO.getPoints());
        Mockito.when(resultSet.getString("type")).thenReturn(String.valueOf(studentPointDTO.getType()));

        RowMapper<StudentPointDTO> rowMapper = new StudentPointMapper();

        StudentPointDTO dtoResponse = rowMapper.mapRow(resultSet,1);

        Assert.assertNotNull(dtoResponse);

    }

}
