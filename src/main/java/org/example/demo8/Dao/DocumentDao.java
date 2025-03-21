package org.example.demo8.Dao;

import org.example.demo8.Entity.Document;

import java.util.List;
import com.google.gson.Gson;

public interface DocumentDao {
    public List<Document> getAllDocuments();
}
