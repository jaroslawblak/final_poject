package com.blak.csvgenerator.UserRes;

import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDate;

public class CsvUserRes {

    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private int type;
    @CsvBindByPosition(position = 2)
    private int state;
    @CsvBindByPosition(position = 3)
    private LocalDate addTime;
    @CsvBindByPosition(position = 4)
    private LocalDate delTime;
    @CsvBindByPosition(position = 5)
    private Integer priority;
    @CsvBindByPosition(position = 6)
    private LocalDate dateFrom;
    @CsvBindByPosition(position = 7)
    private LocalDate dateTo;
    @CsvBindByPosition(position = 8)
    private String note;
    @CsvBindByPosition(position = 9)
    private int userId;
    @CsvBindByPosition(position = 10)
    private int resourceId;
    @CsvBindByPosition(position = 11)
    private int parentId;

    public CsvUserRes() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
