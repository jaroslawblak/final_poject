package com.blak.csvgenerator.document;

import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDate;

public class CsvDocument {

    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String fileName;
    @CsvBindByPosition(position = 2)
    private String title;
    @CsvBindByPosition(position = 3)
    private int type;
    @CsvBindByPosition(position = 4)
    private LocalDate addTime;
    @CsvBindByPosition(position = 5)
    private LocalDate delTime;
    @CsvBindByPosition(position = 6)
    private int resource;

    public CsvDocument() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDate getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDate addTime) {
        this.addTime = addTime;
    }

    public LocalDate getDelTime() {
        return delTime;
    }

    public void setDelTime(LocalDate delTime) {
        this.delTime = delTime;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
