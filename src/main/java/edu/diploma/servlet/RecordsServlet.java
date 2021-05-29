package edu.diploma.servlet;

import edu.diploma.dao.CrudDAO;
import edu.diploma.dao.RecordDAOImpl;
import edu.diploma.entity.Patient;
import edu.diploma.entity.Record;

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

@WebServlet(name = "RecordsServlet", urlPatterns = {"/recordsServlet"})
public class RecordsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        CrudDAO<Record> recordCRUD = new RecordDAOImpl();

        int id = patient.getPatientId();

        patient.setRecords(recordCRUD.findAll(id));

        req.setAttribute("records", patient.getRecords());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("records.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        String doctor = req.getParameter("doctor");
        String disease = req.getParameter("disease");
        String hospital = req.getParameter("hospital");
        String complains = req.getParameter("complains");
        String address = req.getParameter("address");
        String treatment = req.getParameter("treatment");

        Record record = new Record(
                LocalDate.now(), disease, complains, treatment,
                hospital, address, doctor, patient
        );

        CrudDAO<Record> recordCRUD = new RecordDAOImpl();

        recordCRUD.save(record);

        int id = patient.getPatientId();

        patient.setRecords(recordCRUD.findAll(id));

        req.setAttribute("records", patient.getRecords());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("records.jsp");
        requestDispatcher.forward(req, resp);

    }
}
