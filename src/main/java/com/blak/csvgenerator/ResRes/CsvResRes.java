package com.blak.csvgenerator.ResRes;

import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDate;

public class CsvResRes {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private LocalDate addTime;
    @CsvBindByPosition(position = 2)
    private LocalDate delTime;
    @CsvBindByPosition(position = 3)
    private int type;
    @CsvBindByPosition(position = 4)
    private int state;
    @CsvBindByPosition(position = 5)
    private int parentId;
    @CsvBindByPosition(position = 6)
    private int childId;

    public CsvResRes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }
}
