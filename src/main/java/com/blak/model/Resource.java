package com.blak.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "resource")
@JsonIdentityInfo(scope = Resource.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Resource {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Type", nullable = false)
    private int type;
    @Column(name = "State", nullable = false)
    private int state;
    @Column(name = "AddTime", nullable = false)
    private LocalDate addTime;
    @Column(name = "DelTime")
    private LocalDate delTime;
    @Column(name = "ExternalID")
    private String externalId;

    private boolean onLoan;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "PlaceID",nullable = false)
    private Place place;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ParentID")
    private Resource parentResource;

    @OneToMany(mappedBy = "resourceId", fetch = FetchType.LAZY)
    private List<Document> documents;

    @OneToMany(mappedBy = "resource", fetch = FetchType.LAZY)
    private List<UserResources> userResources;

    @OneToMany(mappedBy = "resourceId", fetch = FetchType.LAZY)
    private List<ResourceCategory> resourceCategories;

    @OneToMany(mappedBy = "childResourceOfResource", fetch = FetchType.LAZY)
    private List<ResourceOfResource> childResourceOfResource;

    @OneToMany(mappedBy = "parentResourceOfResource", fetch = FetchType.LAZY)
    private List<ResourceOfResource> parentResourceOfResource;

    @OneToMany(mappedBy = "parentResource")
    private List<Resource> resources;

    public Resource() {
    }

    public Resource(String name, int type, int state, LocalDate addTime, Place placeId) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.addTime = addTime;
        this.place = placeId;
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

    public Place getPlaceId() {
        return place;
    }

    public void setPlaceId(Place placeId) {
        this.place = placeId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Resource getParentId() {
        return parentResource;
    }

    public void setParentId(Resource parentResource) {
        this.parentResource = parentResource;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", addTime=" + addTime +
                ", delTime=" + delTime +
                ", placeId=" + place +
                ", externalId='" + externalId + '\'' +
                ", parentResource=" + parentResource +
                '}';
    }
}
