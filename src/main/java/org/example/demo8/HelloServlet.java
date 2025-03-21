package org.example.demo8;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.google.gson.Gson;
import org.example.demo8.Dao.DocumentDao;
import org.example.demo8.DaoImp.DocDaoImp;
import org.example.demo8.Entity.Book;
import org.example.demo8.Entity.Document;
import org.example.demo8.Entity.Magazine;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();
        transac.begin();

        Magazine mag = new Magazine();;
        Book book = new Book();
        Document doc = new Document();
        em.persist(doc);

        transac.commit();
        em.close();
        emf.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Gson conv = new Gson();
        DocumentDao DocDao = new DocDaoImp();
        List<String> jsonDocs = DocDao.getAllDocuments().stream().map(document -> conv.toJson(document)).collect(Collectors.toList());
        response.getWriter().println(jsonDocs);
    }

    public void destroy() {
        super.destroy();
    }
}