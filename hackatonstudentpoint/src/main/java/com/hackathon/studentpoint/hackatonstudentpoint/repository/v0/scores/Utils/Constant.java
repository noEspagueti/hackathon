package com.hackathon.studentpoint.hackatonstudentpoint.repository.v0.scores.Utils;

public final class Constant {
    private Constant() {
    }

    public static final String TABLE_DB_NAME = "tbl_student_points ";

    public static final String CONSULT = "SELECT * FROM ";
    public static final String INGESTION = "INSERT INTO ";
    public static final String UPDATE = "UPDATE ";

    public static final String FIELD_ID = "id";
    public static final String FIELD_STUDENT_CODE = "student_code";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_DAY_ID = "day_id";
    public static final String FIELD_POINTS = "points";

    public static final String ID = "idStudentPoint";
    public static final String STUDENT_CODE = "studentCode";
    public static final String POINTS = "pointsStudentScore";
    public static final String TYPE = "type";
    public static final String DAY_ID = "dayId";

    public static final String PER_ID = "WHERE id = :" + ID;

    public static final String FIELD_CREATE_FULL = new StringBuilder("VALUES(")
            .append(":" + ID + ",")
            .append(":" + STUDENT_CODE + ",")
            .append(":" + POINTS + ",")
            .append(":" + TYPE + ",")
            .append(":" + DAY_ID + ")").toString();

    public static final String UPDATE_FIELDS = new StringBuilder("SET ")
            .append(FIELD_POINTS)
            .append("= :")
            .append(POINTS + " ")
            .toString();


}
