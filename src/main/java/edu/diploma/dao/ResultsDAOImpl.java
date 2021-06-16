package edu.diploma.dao;

import edu.diploma.entity.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResultsDAOImpl implements CrudDAO<Result>{

    private Connection connection;

    private static final String SQL_SAVE_RESULT =
            "INSERT INTO results (" +
                    "created_in, " +
                    "file_path, " +
                    "description, " +
                    "patient_id, " +
                    "name) " +
                    "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_RESULT =
            "DELETE FROM results WHERE file_path=?";

    private static final String SQL_SELECT_ALL_RESULTS =
            "SELECT * FROM results WHERE patient_id=? ORDER BY result_id DESC";

    @Override
    public Result find(Integer id) {
        return null;
    }

    @Override
    public int save(Result result) {

        int status = 0;

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE_RESULT)){

            preparedStatement.setObject(1, result.getCreatedIn());
            preparedStatement.setString(2, result.getFilePath());
            preparedStatement.setString(3, result.getDescription());
            preparedStatement.setInt(4, result.getPatient().getPatientId());
            preparedStatement.setString(5, result.getName());

            status = preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new IllegalStateException(e);
        }

        return 0;

    }

    @Override
    public int update(Result model) {
        return 0;
    }

    @Override
    public int delete(Integer id) {

        int status = 0;

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_RESULT)){

            preparedStatement.setInt(1, id);

            status = preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return 0;

    }

    @Override
    public List<Result> findAll(int id) {

        List<Result> results = new ArrayList<>();

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_RESULTS)){

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Result result = new Result();
                result.setResultId(resultSet.getInt("result_id"));
                result.setCreatedIn(resultSet.getObject("created_in", LocalDate.class));
                result.setFilePath(resultSet.getString("file_path"));
                result.setDescription(resultSet.getString("description"));
                result.setName(resultSet.getString("name"));

                results.add(result);

            }

        } catch (SQLException e){
            throw new IllegalStateException(e);
        }

        return results;

    }
}
