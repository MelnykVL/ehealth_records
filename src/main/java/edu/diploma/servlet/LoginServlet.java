package edu.diploma.servlet;

import edu.diploma.dao.LoginDAO;
import edu.diploma.dao.PatientDAOImpl;
import edu.diploma.dao.CrudDAO;
import edu.diploma.entity.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("pass");

        Patient patient = null;

        int id = LoginDAO.validate(email, password);

        HttpSession session = req.getSession();

        if(id > 0){

            CrudDAO<Patient> p = new PatientDAOImpl();

            patient = p.find(id);

            session.setAttribute("patient", patient);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/profile.jsp");
            requestDispatcher.forward(req, resp);

        } else {

            out.write("<script type=\"text/javascript\">\n" +
                    "alert(\"Email або пароль введені невірно!\")" +
                    "</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
            requestDispatcher.include(req, resp);

        }

        out.close();

    }

}
