package edu.diploma.servlet;

import edu.diploma.dao.PatientDAOImpl;
import edu.diploma.dao.CrudDAO;
import edu.diploma.dao.LoginDAO;
import edu.diploma.entity.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/signUp"})
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String fullName = req.getParameter("full_name");
        Integer weight = Integer.parseInt(req.getParameter("weight"));
        Integer height = Integer.parseInt(req.getParameter("height"));
        String addressOfResidence = req.getParameter("address_of_residence");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        String sex = req.getParameter("select_sex");
        String bloodType = req.getParameter("select_blood_type");
        String profession;
        if(req.getParameter("select_prof").equals("Other")) {
            profession = req.getParameter("profession");
        } else {
            profession = req.getParameter("select_prof");
        }

        if(LoginDAO.validate(email)){

            out.write("<h2 class=\"user__title\">" + "Користувач з такою електронною поштою вже існує!" + "</h2>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("sign_up.html");
            requestDispatcher.include(req, resp);

        } else{

            Patient patient = new Patient(
                    email, pass, fullName,
                    birthday, weight, height, sex,
                    addressOfResidence, bloodType, profession
            );

            CrudDAO<Patient> p = new PatientDAOImpl();
            if(p.save(patient) > 0) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
                requestDispatcher.forward(req, resp);
            } else
                out.write("<h1>" + "You have a problem" + "</h1>");
        }

        out.close();

    }
}
