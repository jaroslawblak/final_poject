package com.blak.csvgenerator.resources;

import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDate;
import java.util.Objects;

public class CsvResource {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String description;
    @CsvBindByPosition(position = 3)
    private int type;
    @CsvBindByPosition(position = 4)
    private int state;
    @CsvBindByPosition(position = 5)
    private LocalDate addTime;
    @CsvBindByPosition(position = 6)
    private LocalDate delTime;
    @CsvBindByPosition(position = 7)
    private String externalId;
    @CsvBindByPosition(position = 8)
    private int placeId;
    @CsvBindByPosition(position = 9)
    private int parentResourceId;


    public CsvResource() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CsvResource that = (CsvResource) o;
        return id == that.id &&
                type == that.type &&
                state == that.state &&
                placeId == that.placeId &&
                parentResourceId == that.parentResourceId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(delTime, that.delTime) &&
                Objects.equals(externalId, that.externalId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, type, state, addTime, delTime, externalId, placeId, parentResourceId);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getParentResourceId() {
        return parentResourceId;
    }

    public void setParentResourceId(int parentResourceId) {
        this.parentResourceId = parentResourceId;
    }
}
