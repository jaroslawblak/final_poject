package com.blak.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "place")
@JsonIdentityInfo(scope = Place.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Place {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Note")
    private String note;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ParentID")
    private Place parentPlace;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
    private List<Resource> resources;

    @OneToMany(mappedBy = "parentPlace")
    private List<Place> places;

    public Place() {
    }

    public Place(String name) {
        this.name = name;
        this.resources = new ArrayList<>();
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

    public Place getParentId() {
        return parentPlace;
    }

    public void setParentId(Place parentPlace) {
        this.parentPlace = parentPlace;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", parentPlace=" + parentPlace +
                '}';
    }
}
