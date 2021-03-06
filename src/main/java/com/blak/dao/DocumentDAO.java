package com.blak.dao;

import com.blak.model.Document;
import com.blak.model.Resource;

import java.util.List;

public interface DocumentDAO {

    public Document getDocument(int id);
    public void saveDocument(Document document);
    public boolean deleteDocument (int id);
    public List<Document> findDocumentByResource(Resource resource);
    public List<Document> getDocuments();
    public Document getDocumentByResourceId(int id);
}
