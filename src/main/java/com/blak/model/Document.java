package com.blak.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "document")
@JsonIdentityInfo(scope = Document.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Document {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Filename" , nullable = false)
    private String fileName;
    @Column(name = "Title" , nullable = false)
    private String title;
    @Column(name = "Type" , nullable = false)
    private int type;
    @Column(name = "AddTime" , nullable = false, columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate addTime;
    @Column(name = "DelTime", columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate delTime;


    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ResourceID",nullable = false)
    private Resource resourceId;

    public Document() {
    }

    public Document(String fileName, String title, int type, LocalDate addTime, Resource resourceId) {
        this.fileName = fileName;
        this.title = title;
        this.type = type;
        this.addTime = addTime;
        this.resourceId = resourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Resource getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource resourceId) {
        this.resourceId = resourceId;
    }


    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", addTime=" + addTime +
                ", delTime=" + delTime +
                ", resourceId=" + resourceId +
                '}';
    }
}
