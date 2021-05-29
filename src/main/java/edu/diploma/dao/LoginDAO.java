package edu.diploma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public static int validate(String email,String pass){

        int status = 0;

        try (Connection con = ConnectionDB.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,pass);

            ResultSet rs = ps.executeQuery();

            //status = rs.getInt("patient_id");

            if(rs.next())
                status = rs.getInt("patient_id");

            return status;

        }catch(Exception e){
            System.out.println(e);
        }

        return status;

    }

    public static boolean validate(String email) {

        boolean status = false;

        try (Connection con = ConnectionDB.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE email=?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e){
            System.out.println(e);
        }

        return status;

    }
}
