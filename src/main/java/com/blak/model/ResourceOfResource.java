package com.blak.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "res2res")
@JsonIdentityInfo(scope = ResourceOfResource.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ResourceOfResource {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AddTime", nullable = false)
    private LocalDate addTime;

    @Column(name = "DelTime")
    private LocalDate delTime;

    @Column(name = "State", nullable = false)
    private int state;

    @Column(name = "Type", nullable = false)
    private int type;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ChildID",nullable = false)
    private ResourceOfResource childResourceOfResource;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ParentID",nullable = false)
    private ResourceOfResource parentResourceOfResource;

    public ResourceOfResource() {
    }

    public ResourceOfResource(LocalDate addTime, int state, int type, ResourceOfResource childResourceOfResource, ResourceOfResource parentResourceOfResource) {
        this.addTime = addTime;
        this.state = state;
        this.type = type;
        this.childResourceOfResource = childResourceOfResource;
        this.parentResourceOfResource = parentResourceOfResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ResourceOfResource getChildResourceOfResource() {
        return childResourceOfResource;
    }

    public void setChildResourceOfResource(ResourceOfResource childResourceOfResource) {
        this.childResourceOfResource = childResourceOfResource;
    }

    public ResourceOfResource getParentResourceOfResource() {
        return parentResourceOfResource;
    }

    public void setParentResourceOfResource(ResourceOfResource parentResourceOfResource) {
        this.parentResourceOfResource = parentResourceOfResource;
    }

    @Override
    public String toString() {
        return "ResourceOfResource{" +
                "id=" + id +
                ", addTime=" + addTime +
                ", delTime=" + delTime +
                ", state=" + state +
                ", type=" + type +
                ", childResourceOfResource=" + childResourceOfResource +
                ", parentResourceOfResource=" + parentResourceOfResource +
                '}';
    }
}
