package com.blak.csvgenerator.Category;

import com.opencsv.bean.CsvBindByPosition;

import java.util.List;

public class CsvCategory {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String note;
    @CsvBindByPosition(position = 3)
    private int parentCategoryId;
    @CsvBindByPosition(position = 4)
    private List<Integer> childCategoriesIds;

    public CsvCategory() {
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

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public List<Integer> getChildCategoriesIds() {
        return childCategoriesIds;
    }

    public void setChildCategoriesIds(List<Integer> childCategoriesIds) {
        this.childCategoriesIds = childCategoriesIds;
    }
}
