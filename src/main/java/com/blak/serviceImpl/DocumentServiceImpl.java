package com.blak.serviceImpl;

import com.blak.csvgenerator.document.DocumentCsvWriter;
import com.blak.dao.DocumentDAO;
import com.blak.model.Document;
import com.blak.model.Resource;
import com.blak.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {


    @Autowired
    private DocumentDAO documentDAO;

    @Autowired
    private DocumentCsvWriter documentCsvWriter;

    @Override
    @Transactional
    public Document getDocument(int id) {
        return documentDAO.getDocument(id);
    }

    @Override
    @Transactional
    public Document getDocumentByResourceId(int id) {
        return documentDAO.getDocumentByResourceId(id);
    }

    @Override
    @Transactional
    public void saveDocument(Document document) {
        documentDAO.saveDocument(document);

    }

    public ClassPathResource getFileForDocument(String path) {
       ClassPathResource pdfFile = new ClassPathResource(path);
        return pdfFile;
    }
    @Override
    @Transactional
    public boolean deleteDocument(int id) {
        return documentDAO.deleteDocument(id);
    }

    @Override
    @Transactional
    public List<Document> findDocumentByResource(Resource resource) {
        return documentDAO.findDocumentByResource(resource);
    }

    @Override
    @Transactional
    public List<Document> getDocuments() {
        return documentDAO.getDocuments();
    }

    @Override
    @Transactional
    public void getCsvDocuments(Path path) throws Exception {
        this.documentCsvWriter.writeCsv(path);
    }
}
