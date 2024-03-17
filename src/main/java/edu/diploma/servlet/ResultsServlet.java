package edu.diploma.servlet;

import com.oreilly.servlet.MultipartRequest;
import edu.diploma.dao.CrudDAO;
import edu.diploma.dao.ResultsDAOImpl;
import edu.diploma.entity.Patient;
import edu.diploma.entity.Result;

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

@WebServlet(name = "ResultsServlet", urlPatterns = {"/resultsServlet"})
public class ResultsServlet extends HttpServlet {

    static String Path = "/Diploma-1.0/results/";
    static String ServerPath = "/home/vlad/Apache Tomcat/apache-tomcat-9.0.45/webapps/Diploma-1.0/results";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        CrudDAO<Result> resultCRUD = new ResultsDAOImpl();

        int id = patient.getPatientId();

        patient.setResults(resultCRUD.findAll(id));

        req.setAttribute("results", patient.getResults());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("results.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        MultipartRequest m = new MultipartRequest(req, ServerPath);

        String description = req.getParameter("description");

        out.write("<script type=\"text/javascript\">\n" +
                "alert(\"" + description + "\")" +
                "</script>");

        Result result = new Result(
                LocalDate.now(), Path + m.getFilesystemName("file"),
                description, m.getFilesystemName("file"), patient
        );

        CrudDAO<Result> resultsCRUD = new ResultsDAOImpl();

        resultsCRUD.save(result);

        int id = patient.getPatientId();

        patient.setResults(resultsCRUD.findAll(id));

        req.setAttribute("results", patient.getResults());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("results.jsp");
        requestDispatcher.forward(req, resp);

    }

}

