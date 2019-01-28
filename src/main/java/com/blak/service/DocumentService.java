package com.blak.service;

import com.blak.model.Document;
import com.blak.model.Resource;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Path;
import java.util.List;

public interface DocumentService {

    public Document getDocument(int id);
    public Document getDocumentByResourceId(int id);
    public void saveDocument(Document document);
    public boolean deleteDocument (int id);
    public List<Document> findDocumentByResource(Resource resource);
    public List<Document> getDocuments();
    public ClassPathResource getFileForDocument(String path );
    public void getCsvDocuments (Path path) throws Exception;

}
