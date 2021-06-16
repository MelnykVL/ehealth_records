package edu.diploma.dao;

import edu.diploma.entity.Record;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecordDAOImpl implements CrudDAO<Record>{

    private static final String SQL_SAVE_RECORD =
            "INSERT INTO records (" +
                    "created_in, " +
                    "disease, " +
                    "complains, " +
                    "medical_treatment, " +
                    "name_of_hospital, " +
                    "address_of_hospital, " +
                    "name_of_doctor, " +
                    "patient_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_RECORD =
            "DELETE FROM records WHERE record_id=?";

    private static final String SQL_SELECT_ALL_RECORDS =
            "SELECT * FROM records WHERE patient_id=? ORDER BY record_id DESC";

    @Override
    public Record find(Integer id) {
        return null;
    }

    @Override
    public int save(Record record) {

        int status = 0;

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE_RECORD)){

            preparedStatement.setObject(1, record.getCreatedIn());
            preparedStatement.setString(2, record.getDisease());
            preparedStatement.setString(3, record.getComplains());
            preparedStatement.setString(4, record.getMedicalTreatment());
            preparedStatement.setString(5, record.getNameOfHospital());
            preparedStatement.setString(6, record.getAddressOfHospital());
            preparedStatement.setString(7, record.getNameOfDoctor());
            preparedStatement.setInt(8, record.getPatient().getPatientId());

            status = preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new IllegalStateException(e);
        }

        return 0;
    }

    @Override
    public int update(Record model) {
        return 0;
    }

    @Override
    public int delete(Integer id) {

        int status = 0;

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_RECORD)){

            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Record> findAll(int id) {

        List<Record> records = new ArrayList<>();

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_RECORDS)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Record record = new Record();
                record.setRecordId(resultSet.getInt("record_id"));
                record.setCreatedIn(resultSet.getObject("created_in", LocalDate.class));
                record.setDisease(resultSet.getString("disease"));
                record.setComplains(resultSet.getString("complains"));
                record.setMedicalTreatment(resultSet.getString("medical_treatment"));
                record.setNameOfHospital(resultSet.getString("name_of_hospital"));
                record.setAddressOfHospital(resultSet.getString("address_of_hospital"));
                record.setNameOfDoctor(resultSet.getString("name_of_doctor"));

                records.add(record);

            }

        } catch (SQLException e){
            throw new IllegalStateException(e);
        }

        return records;
    }
}
