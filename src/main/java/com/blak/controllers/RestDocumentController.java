package com.blak.controllers;

import com.blak.model.Document;
import com.blak.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin

public class RestDocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public List<Document> getDocuments() {
        List<Document> documents = documentService.getDocuments();
        return documents;
    }

    @GetMapping("/documents/{id}")
    public Document getDocument(@PathVariable int id) {
        Document document = documentService.getDocument(id);
        return document;
    }

    @PostMapping("/documents")
    public void saveResource(@RequestBody Document document) {
        document.setId(0);
        documentService.saveDocument(document);
    }

    @PutMapping("/documents")
    public void updateResource(@RequestBody Document document) {
        documentService.saveDocument(document);
    }

    @DeleteMapping("/documents/{id}")
    public void deleteResource(@PathVariable int id) {
        Document document = documentService.getDocument(id);
        if (document == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        documentService.deleteDocument(id);
    }

    @GetMapping("/documents/csv")
    public void getCSVUsers() throws Exception {
        Path p1 = Paths.get("/tmp/foo");
        documentService.getCsvDocuments(p1);
    }
}
