package edu.diploma.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public static int validate(String email, String pass) {

        int status = 0;

        try (PreparedStatement ps = ConnectionDB.getPrepareStatement("SELECT * FROM patients WHERE email=? AND password=?")) {
            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            //status = rs.getInt("patient_id");

            if (rs.next())
                status = rs.getInt("patient_id");

//            return status;

        } catch (Exception e) {
            System.out.println(e);
        }

        return status;

    }

    public static boolean validate(String email) {

        boolean status = false;

        try (PreparedStatement ps = ConnectionDB.getPrepareStatement("SELECT * FROM patients WHERE email=?")) {
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;

    }
}
