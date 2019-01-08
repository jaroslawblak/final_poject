package com.blak.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Note")
    private String note;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ParentID")
    private Place parentPlace;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Resource> resources;

    @OneToMany(mappedBy = "parentPlace", fetch = FetchType.LAZY)
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

    public Place getParentPlace() {
        return parentPlace;
    }

    public void setParentPlace(Place parentPlace) {
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
