package com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.Utils;

public final class Constant {
    private Constant() {}
    public static final String TABLE_DB_NAME = "tbl_student_points ";
    public static final String CONSULT = "SELECT * FROM ";
    public static final String PER_ID = "WHERE id = :idStudentPoint ";


    public static final String FIELD_ID = "id";
    public static final String FIELD_STUDENT_CODE = "student_code";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_DAY_ID= "day_id";
    public static final String FIELD_POINTS = "points";
}
