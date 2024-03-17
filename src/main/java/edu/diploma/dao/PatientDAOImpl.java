package edu.diploma.dao;

import edu.diploma.entity.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PatientDAOImpl implements CrudDAO<Patient> {

    private static final String SQL_SELECT_BY_ID =
            "SELECT * FROM patients WHERE patient_id=?";

    private static final String SQL_INSERT_ALL =
            "INSERT INTO patients (" +
                    "email, " +
                    "password, " +
                    "full_name, " +
                    "birthday, " +
                    "weight, " +
                    "height, " +
                    "sex, " +
                    "address_of_residence, " +
                    "blood_type, " +
                    "profession) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_INFO =
            "UPDATE patients SET " +
                    "full_name=?, " +
                    "weight=?, " +
                    "height=?, " +
                    "address_of_residence=?, " +
                    "address_of_work=?, " +
                    "profession=?" +
                    "WHERE patient_id=?";

    private static final String SQL_DELETE_ACCOUNT =
            "DELETE FROM patients WHERE patient_id=?";

    private static final String SQL_SELECT_BY_EMAIL_AND_PASS =
            "SELECT * FROM patients WHERE email=? AND password=?";

    @Override
    public Patient find(Integer id) {

        Patient patient = null;

        try (PreparedStatement preparedStatement = ConnectionDB.getPrepareStatement(SQL_SELECT_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                patient = new Patient(
                        resultSet.getInt("patient_id"),
                        resultSet.getString("email"),
                        resultSet.getString("full_name"),
                        resultSet.getObject("birthday", LocalDate.class),
                        resultSet.getInt("weight"),
                        resultSet.getInt("height"),
                        resultSet.getString("sex"),
                        resultSet.getString("info"),
                        resultSet.getString("address_of_residence"),
                        resultSet.getString("address_of_work"),
                        resultSet.getString("blood_type"),
                        resultSet.getString("profession")
                );
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return patient;
    }

    @Override
    public int save(Patient patient) {

        int status = 0;

        try (PreparedStatement preparedStatement = ConnectionDB.getPrepareStatement(SQL_INSERT_ALL)) {

            preparedStatement.setString(1, patient.getEmail());
            preparedStatement.setString(2, patient.getPassword());
            preparedStatement.setString(3, patient.getFullName());
            preparedStatement.setObject(4, patient.getBirthday());
            preparedStatement.setInt(5, patient.getWeight());
            preparedStatement.setInt(6, patient.getHeight());
            preparedStatement.setString(7, patient.getSex());
            preparedStatement.setString(8, patient.getAddressOfResidence());
            preparedStatement.setString(9, patient.getBloodType());
            preparedStatement.setString(10, patient.getProfession());

            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int update(Patient patient) {

        int status = 0;

        try (PreparedStatement preparedStatement = ConnectionDB.getPrepareStatement(SQL_UPDATE_INFO)) {

            preparedStatement.setString(1, patient.getFullName());
            preparedStatement.setInt(2, patient.getWeight());
            preparedStatement.setInt(3, patient.getHeight());
            preparedStatement.setString(4, patient.getAddressOfResidence());
            preparedStatement.setString(5, patient.getAddressOfWork());
            preparedStatement.setString(6, patient.getProfession());
            preparedStatement.setInt(7, patient.getPatientId());

            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public int delete(Integer id) {

        int status = 0;

        try (PreparedStatement preparedStatement = ConnectionDB.getPrepareStatement(SQL_DELETE_ACCOUNT)) {

            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<Patient> findAll(int id) {
        return null;
    }

}
