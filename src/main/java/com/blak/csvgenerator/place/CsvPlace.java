package com.blak.csvgenerator.place;

import com.opencsv.bean.CsvBindByPosition;

import java.util.List;

public class CsvPlace {

    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String note;
    @CsvBindByPosition(position = 3)
    private int parentPlaceId;
    @CsvBindByPosition(position = 4)
    private List<Integer> childUsersIds;

    public CsvPlace() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getParentPlaceId() {
        return parentPlaceId;
    }

    public void setParentPlaceId(int parentPlaceId) {
        this.parentPlaceId = parentPlaceId;
    }

    public List<Integer> getChildUsersIds() {
        return childUsersIds;
    }

    public void setChildUsersIds(List<Integer> childUsersIds) {
        this.childUsersIds = childUsersIds;
    }
}
