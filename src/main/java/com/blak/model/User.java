package com.blak.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FirstName", nullable = false)
    private String firstName;
    @Column(name = "LastName", nullable = false)
    private String lastName;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Type", nullable = false)
    private int type;
    @Column(name = "State", nullable = false)
    private int state;
    @Column(name = "AddTime", nullable = false)
    private LocalDate addTime;
    @Column(name = "DelTime")
    private LocalDate delTime;
    @Column(name = "Note")
    private String note;
    @Column(name = "AuthKey", nullable = false)
    private String authKey;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ParentID")
    private User parentUser;

    @OneToMany(mappedBy = "parentUser")
    private List<User> users;

    @OneToMany(mappedBy = "user")
    @Transient
    private List<UserResources> userResources;


    public User() {
    }

    public User(String firstName, String lastName, String email, String password, int type, int state, LocalDate addTime, String authKey) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.state = state;
        this.addTime = addTime;
        this.authKey = authKey;
        this.userResources = new LinkedList<>();
        this.parentUser = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getParentUser() {
        return this.parentUser;
    }

    public void setParentUser(User user) {
        this.parentUser = user;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public List<UserResources> getUserResources() {
        return userResources;
    }

    public void setUserResources(List<UserResources> userResources) {
        this.userResources = userResources;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", addTime=" + addTime +
                ", delTime=" + delTime +
                ", note='" + note + '\'' +
                ", authKey='" + authKey + '\'' +
                ", parentUser=" + parentUser +
                ", userResources=" + userResources +
                '}';
    }
}
