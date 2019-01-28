package com.blak.controllers;

import com.blak.model.Document;
import com.blak.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/documents/resource/{id}")
    public ResponseEntity<InputStreamResource> getDocumentByResourceId(@PathVariable int id)  throws IOException {
        Document document = documentService.getDocumentByResourceId(id);
        ClassPathResource pdfFile = documentService.getFileForDocument(document.getPath());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/pdf"));
        httpHeaders.add("Content-Disposition", "filename=" + document.getFileName());
        httpHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");

        ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
                new InputStreamResource(pdfFile.getInputStream()), httpHeaders, HttpStatus.OK);
        return response;
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
