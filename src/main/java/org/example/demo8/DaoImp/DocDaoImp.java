package org.example.demo8.DaoImp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.demo8.Dao.DocumentDao;
import org.example.demo8.Entity.Document;

import java.util.List;

public class DocDaoImp implements DocumentDao {
    @Override
    public List<Document> getAllDocuments() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();
        transac.begin();

        List<Document> documents = em.createQuery("SELECT d FROM Document d").getResultList();


        transac.commit();
        em.close();
        emf.close();
        return documents;
    }

}
