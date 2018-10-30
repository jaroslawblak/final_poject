package com.blak.serviceImpl;

import com.blak.model.Document;
import com.blak.model.Resource;
import com.blak.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {


    @Autowired
    private DocumentService documentService;


    @Override
    @Transactional
    public Document getDocument(int id) {
        return documentService.getDocument(id);
    }

    @Override
    @Transactional
    public void saveDocument(Document document) {
        documentService.saveDocument(document);

    }

    @Override
    @Transactional
    public boolean deleteDocument(int id) {
        return documentService.deleteDocument(id);
    }

    @Override
    @Transactional
    public List<Document> findDocumentByResource(Resource resource) {
        return documentService.findDocumentByResource(resource);
    }

    @Override
    @Transactional
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }
}
