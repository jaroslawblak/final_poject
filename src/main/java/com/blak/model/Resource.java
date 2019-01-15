package com.blak.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "resource")
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
    @Column(name = "AddTime", nullable = false, columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate addTime;
    @Column(name = "DelTime", columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate delTime;
    @Column(name = "ExternalID")
    private String externalId;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "PlaceID", nullable = false)
    private Place place;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ParentID")
    private Resource parentResource;

    @OneToMany(mappedBy = "parentResource", fetch = FetchType.LAZY)
    @Transient
    private List<Resource> resources;

    @OneToMany(mappedBy = "resourceId", fetch = FetchType.LAZY)
    @Transient
    private List<Document> documents;

    @OneToMany(mappedBy = "resource", fetch = FetchType.LAZY)
    @Transient
    private List<UserResources> userResources;

    @OneToMany(mappedBy = "resourceId", fetch = FetchType.LAZY)
    @Transient
    private List<ResourceCategory> resourceCategories;

    @OneToMany(mappedBy = "childResourceOfResource", fetch = FetchType.LAZY)
    @Transient
    private List<ResourceOfResource> childResourceOfResource;

    @OneToMany(mappedBy = "parentResourceOfResource", fetch = FetchType.LAZY)
    @Transient
    private List<ResourceOfResource> parentResourceOfResource;


    public Resource() {
    }

    public Resource(String name, int type, int state, LocalDate addTime) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.addTime = addTime;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place placeId) {
        this.place = placeId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Resource getParentResource() {
        return parentResource;
    }

    public void setParentResource(Resource parentResource) {
        this.parentResource = parentResource;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<UserResources> getUserResources() {
        return userResources;
    }

    public void setUserResources(List<UserResources> userResources) {
        this.userResources = userResources;
    }

    public List<ResourceCategory> getResourceCategories() {
        return resourceCategories;
    }

    public void setResourceCategories(List<ResourceCategory> resourceCategories) {
        this.resourceCategories = resourceCategories;
    }

    public List<ResourceOfResource> getChildResourceOfResource() {
        return childResourceOfResource;
    }

    public void setChildResourceOfResource(List<ResourceOfResource> childResourceOfResource) {
        this.childResourceOfResource = childResourceOfResource;
    }

    public List<ResourceOfResource> getParentResourceOfResource() {
        return parentResourceOfResource;
    }

    public void setParentResourceOfResource(List<ResourceOfResource> parentResourceOfResource) {
        this.parentResourceOfResource = parentResourceOfResource;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", externalId='" + externalId + '\'' +
                ", parentResource=" + parentResource.getId() +
                '}';
    }
}
