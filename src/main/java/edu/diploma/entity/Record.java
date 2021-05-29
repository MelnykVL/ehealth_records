package edu.diploma.entity;

import java.time.LocalDate;

public class Record {

    private Integer recordId;
    private LocalDate createdIn;
    private String disease;
    private String complains;
    private String medicalTreatment;
    private String nameOfHospital;
    private String addressOfHospital;
    private String nameOfDoctor;
    private Patient patient = new Patient();

    public Record() {

    }

    public Record(LocalDate createdIn, String disease, String complains,
                  String medicalTreatment, String nameOfHospital, String addressOfHospital,
                  String nameOfDoctor, Patient patient) {
        this.createdIn = createdIn;
        this.disease = disease;
        this.complains = complains;
        this.medicalTreatment = medicalTreatment;
        this.nameOfHospital = nameOfHospital;
        this.addressOfHospital = addressOfHospital;
        this.nameOfDoctor = nameOfDoctor;
        this.patient = patient;
    }

    public Record(Integer recordId, LocalDate createdIn, String disease,
                  String complains, String medicalTreatment, String nameOfHospital,
                  String addressOfHospital, String nameOfDoctor, Patient patient) {

        this.recordId = recordId;
        this.createdIn = createdIn;
        this.disease = disease;
        this.complains = complains;
        this.medicalTreatment = medicalTreatment;
        this.nameOfHospital = nameOfHospital;
        this.addressOfHospital = addressOfHospital;
        this.nameOfDoctor = nameOfDoctor;
        this.patient = patient;

    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public LocalDate getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(LocalDate createdIn) {
        this.createdIn = createdIn;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getComplains() {
        return complains;
    }

    public void setComplains(String complains) {
        this.complains = complains;
    }

    public String getMedicalTreatment() {
        return medicalTreatment;
    }

    public void setMedicalTreatment(String medicalTreatment) {
        this.medicalTreatment = medicalTreatment;
    }

    public String getNameOfHospital() {
        return nameOfHospital;
    }

    public void setNameOfHospital(String nameOfHospital) {
        this.nameOfHospital = nameOfHospital;
    }

    public String getAddressOfHospital() {
        return addressOfHospital;
    }

    public void setAddressOfHospital(String addressOfHospital) {
        this.addressOfHospital = addressOfHospital;
    }

    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Record{" +
                "createdIn=" + createdIn +
                ", disease='" + disease + '\'' +
                ", complains='" + complains + '\'' +
                ", medicalTreatment='" + medicalTreatment + '\'' +
                ", nameOfHospital='" + nameOfHospital + '\'' +
                ", addressOfHospital='" + addressOfHospital + '\'' +
                ", nameOfDoctor='" + nameOfDoctor + '\'' +
                ", patient=" + patient.getFullName() +
                '}';
    }
}
