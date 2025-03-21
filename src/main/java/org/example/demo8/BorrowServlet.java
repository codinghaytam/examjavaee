package org.example.demo8;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo8.Dao.BorrowDao;
import org.example.demo8.Dao.DocumentDao;
import org.example.demo8.DaoImp.BorrowDaoImp;
import org.example.demo8.DaoImp.DocDaoImp;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson conv = new Gson();
        BorrowDao DocDao = new BorrowDaoImp();
        List<String> jsonDocs = DocDao.getBorrows().stream().map(b -> conv.toJson(b)).collect(Collectors.toList());
        req.setAttribute("Borrows",jsonDocs);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
