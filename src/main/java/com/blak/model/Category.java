package com.blak.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {


    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Note")
    private String note;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ParentID")
    private Category parentCategory;

    @OneToMany(mappedBy = "categoryId", fetch = FetchType.LAZY)
    private List<ResourceCategory> resourceCategories;

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> categories;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
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

    public Category getParentId() {
        return parentCategory;
    }

    public void setParentId(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", parentCategory=" + parentCategory +
                '}';
    }
}
