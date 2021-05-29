package edu.diploma.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {

    private Integer patientId;
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthday;
    private Integer weight;
    private Integer height;
    private String sex;
    private String info;
    private String addressOfResidence;
    private String addressOfWork;
    private String bloodType;
    private String profession;
    private List<Record> records = new ArrayList<>();
    private List<Result> results = new ArrayList<>();
    private List<Vaccination> vaccinations = new ArrayList<>();

    public Patient(){

    }

    public Patient(String email, String password, String fullName, LocalDate birthday,
                   Integer weight, Integer height, String sex, String addressOfResidence,
                   String bloodType, String profession) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.addressOfResidence = addressOfResidence;
        this.bloodType = bloodType;
        this.profession = profession;
    }

    public Patient(String email, String fullName,
                   LocalDate birthday, Integer weight, Integer height, String sex,
                   String info, String addressOfResidence, String addressOfWork, String bloodType,
                   String profession, List<Record> records, List<Result> results, List<Vaccination> vaccinations) {

        this.email = email;
        this.fullName = fullName;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.info = info;
        this.addressOfResidence = addressOfResidence;
        this.addressOfWork = addressOfWork;
        this.bloodType = bloodType;
        this.profession = profession;
        this.records = records;
        this.results = results;
        this.vaccinations = vaccinations;

    }

    public Patient(Integer patientId, String email,
                   String fullName, LocalDate birthday, Integer weight,
                   Integer height, String sex, String info, String addressOfResidence,
                   String addressOfWork, String bloodType, String profession) {

        this.patientId = patientId;
        this.email = email;
        this.fullName = fullName;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.info = info;
        this.addressOfResidence = addressOfResidence;
        this.addressOfWork = addressOfWork;
        this.bloodType = bloodType;
        this.profession = profession;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddressOfResidence() {
        return addressOfResidence;
    }

    public void setAddressOfResidence(String addressOfResidence) {
        this.addressOfResidence = addressOfResidence;
    }

    public String getAddressOfWork() {
        return addressOfWork;
    }

    public void setAddressOfWork(String addressOfWork) {
        this.addressOfWork = addressOfWork;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public void addRecord(Record record){
        this.records.add(record);
    }

    public void addResult(Result result){
        this.results.add(result);
    }

    public void addVaccination(Vaccination vaccination){
        this.vaccinations.add(vaccination);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", weight=" + weight +
                ", height=" + height +
                ", sex='" + sex + '\'' +
                ", info='" + info + '\'' +
                ", addressOfResidence='" + addressOfResidence + '\'' +
                ", addressOfWork='" + addressOfWork + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
