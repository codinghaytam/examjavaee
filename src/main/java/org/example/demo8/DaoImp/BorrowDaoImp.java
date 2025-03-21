package org.example.demo8.DaoImp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.demo8.Dao.BorrowDao;
import org.example.demo8.Entity.Borrow;

import java.util.List;

public class BorrowDaoImp implements BorrowDao {
    @Override
    public List<Borrow> getBorrows() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();
        transac.begin();

        List<Borrow> borrows = em.createQuery("SELECT b FROM Borrow b").getResultList();

        transac.commit();
        em.close();
        emf.close();
        return borrows;
    }
    @Override
    public void addBorrow(Borrow borrow) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();
        transac.begin();

        em.persist(borrow);

        transac.commit();
        em.close();
        emf.close();
    }
}
