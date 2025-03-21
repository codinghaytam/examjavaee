package org.example.demo8.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.eclipse.persistence.jpa.config.Cascade;

import java.sql.Date;
@Entity
public class Borrow {
    @Id
    @GeneratedValue
    private Date dateBorrow;
    private Date dateReturn;
    @ManyToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private Document document;

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
