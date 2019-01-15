package com.blak.csvgenerator.document;

import com.blak.model.Document;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentCSVMapper implements Serializable {

    public DocumentCSVMapper() {
    }

    public static CsvDocument toCsvDocument(Document document){
        if(document == null) {
            return null;
        }
        CsvDocument csvDocument = new CsvDocument();

        csvDocument.setId(document.getId());
        csvDocument.setFileName(document.getFileName());
        csvDocument.setTitle(document.getTitle());
        csvDocument.setType(document.getType());
        csvDocument.setAddTime(document.getAddTime());
        csvDocument.setDelTime(document.getDelTime());

        if(document.getResourceId()!= null){
            csvDocument.setResource(document.getResourceId().getId());
        }

        return csvDocument;
    }


    public List<CsvDocument> toCsvDocument(List<Document> documents){
        if(documents == null){
            return null;
        }
        List<CsvDocument> csvDocuments = new ArrayList<>();
        for(Document document: documents){
            CsvDocument tempCsvDocument = this.toCsvDocument(document);
            csvDocuments.add(tempCsvDocument);
        }
        return csvDocuments;
    }
    }