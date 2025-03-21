package org.example.demo8.Dao;

import org.example.demo8.Entity.Borrow;

import java.util.List;

public interface BorrowDao {
    public List<Borrow> getBorrows();
    public void addBorrow(Borrow borrow);
}
