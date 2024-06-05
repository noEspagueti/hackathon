package com.hackathon.studentpoint.hackatonstudentpoint.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Value("${datasource.data.name}")
    private String databaseName;

    @Value("${datasource.password}")
    private String databasePassword;

    @Value("${datasource.url}")
    private String databaseUrl;

    @Bean(Value = "dataSource")
    public DataSource datasource() {
        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl(databaseUrl);
        driverManagerDataSource.setUsername(databaseName);
        driverManagerDataSource.setPassword(databasePassword);
        return driverManagerDataSource;
    }


    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


}
