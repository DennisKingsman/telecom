package web;

import dao.PersonAddDao;
import dao.PoolConnectionBuilder;
import domain.PersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPersonServlet", urlPatterns = {"/addPerson"})
public class AddPersonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AddPersonServlet.class);

    private PersonAddDao dao;

    @Override
    public void init() throws ServletException {
        logger.info(" Server is started ");

        dao = new PersonAddDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get is started ");

        req.setCharacterEncoding("UTF-8");

        String givenName = req.getParameter("givenName");
        String surName = req.getParameter("surName");
        String patronymic = req.getParameter("patronymic");

        PersonRequest request = new PersonRequest();
        request.setGivenName(givenName);
        request.setSurName(surName);
        request.setPatronymic(patronymic);

        try {
            int rows = dao.addPerson(request);
            resp.getWriter().write("Done" + rows);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
