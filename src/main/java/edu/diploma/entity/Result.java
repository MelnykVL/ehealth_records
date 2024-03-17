package edu.diploma.entity;

import java.time.LocalDate;

public class Result {

    private Integer resultId;
    private LocalDate createdIn;
    private String filePath;
    private String description;
    private String name;
    private Patient patient = new Patient();

    public Result() {

    }

    public Result(LocalDate createdIn, String filePath, String description, String name, Patient patient) {
        this.createdIn = createdIn;
        this.filePath = filePath;
        this.description = description;
        this.name = name;
        this.patient = patient;
    }

    public Result(Integer resultId, LocalDate createdIn, String filePath, String description, String name, Patient patient) {
        this.resultId = resultId;
        this.createdIn = createdIn;
        this.filePath = filePath;
        this.description = description;
        this.name = name;
        this.patient = patient;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public LocalDate getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(LocalDate createdIn) {
        this.createdIn = createdIn;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
