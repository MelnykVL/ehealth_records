package edu.diploma.entity;

import java.time.LocalDate;

public class Vaccination {

    private Integer vaccinationId;
    private String vaccineName;
    private LocalDate vaccinated;
    private String reaction;
    private String addressOfBuild;
    private Patient patient = new Patient();

    public Vaccination() {

    }

    public Vaccination(String vaccineName, LocalDate vaccinated, String reaction,
                       String addressOfBuild, Patient patient) {
        this.vaccineName = vaccineName;
        this.vaccinated = vaccinated;
        this.reaction = reaction;
        this.addressOfBuild = addressOfBuild;
        this.patient = patient;
    }

    public Vaccination(Integer vaccinationId, String vaccineName, LocalDate vaccinated,
                       String reaction, String addressOfBuild, Patient patient) {
        this.vaccinationId = vaccinationId;
        this.vaccineName = vaccineName;
        this.vaccinated = vaccinated;
        this.reaction = reaction;
        this.addressOfBuild = addressOfBuild;
        this.patient = patient;
    }

    public Integer getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Integer vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(LocalDate vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public String getAddressOfBuild() {
        return addressOfBuild;
    }

    public void setAddressOfBuild(String addressOfBuild) {
        this.addressOfBuild = addressOfBuild;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
