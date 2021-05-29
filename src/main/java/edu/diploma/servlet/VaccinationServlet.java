package edu.diploma.servlet;

import edu.diploma.dao.CrudDAO;
import edu.diploma.dao.VaccinationsDAOImpl;
import edu.diploma.entity.Patient;
import edu.diploma.entity.Vaccination;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "VaccinationServlet", urlPatterns = {"/vaccinationServlet"})
public class VaccinationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        CrudDAO<Vaccination> vaccinationCRUD = new VaccinationsDAOImpl();

        int id = patient.getPatientId();

        patient.setVaccinations(vaccinationCRUD.findAll(id));

        req.setAttribute("vaccinations", patient.getVaccinations());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("vaccination.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        String vaccineName = req.getParameter("vaccine-name");
        String addressOfBuild = req.getParameter("address-of-build");
        String reaction = req.getParameter("reaction");

        Vaccination Vaccination = new Vaccination(
                vaccineName, LocalDate.now(), reaction,
                addressOfBuild, patient
        );

        CrudDAO<Vaccination> vaccinationsCRUD = new VaccinationsDAOImpl();

        vaccinationsCRUD.save(Vaccination);

        int id = patient.getPatientId();

        patient.setVaccinations(vaccinationsCRUD.findAll(id));

        req.setAttribute("vaccinations", patient.getVaccinations());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("vaccination.jsp");
        requestDispatcher.forward(req, resp);

    }
}
