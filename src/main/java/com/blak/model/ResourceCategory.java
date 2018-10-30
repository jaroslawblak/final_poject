package com.blak.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "res2category")
@JsonIdentityInfo(scope = ResourceCategory.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ResourceCategory {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @ManyToOne
    @JoinColumn(name = "ResourceID",nullable = false)
    private Resource resourceId;

    @ManyToOne
    @JoinColumn(name = "CategoryID",nullable = false)
    private Category categoryId;

    public ResourceCategory() {
    }

    public ResourceCategory(Resource resourceId, Category categoryId) {
        this.resourceId = resourceId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resource getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource resourceId) {
        this.resourceId = resourceId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
