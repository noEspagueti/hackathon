package com.hackathon.studentpoint.hackatonstudentpoint.facade.v0.scores.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentScore {
    private int id;
    private int dayId;
    @NotBlank
    @NotNull
    @NotEmpty
    private String studenCode;
    private int points;
    private char type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getStudenCode() {
        return studenCode;
    }

    public void setStudenCode(String studenCode) {
        this.studenCode = studenCode;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StudentPointDTO{" +
                "id=" + id +
                ", dayId=" + dayId +
                ", studenCode='" + studenCode + '\'' +
                ", points=" + points +
                ", type='" + type + '\'' +
                '}';
    }
}
