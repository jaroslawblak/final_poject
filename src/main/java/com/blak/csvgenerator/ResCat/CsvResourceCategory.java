package com.blak.csvgenerator.ResCat;

import com.opencsv.bean.CsvBindByPosition;

public class CsvResourceCategory {
    @CsvBindByPosition(position = 0)
    private long id;
    @CsvBindByPosition(position = 1)
    private int resourceId;
    @CsvBindByPosition(position = 2)
    private int categoryId;



    public CsvResourceCategory() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
