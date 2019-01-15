package com.blak.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "tel", nullable = false)
    private String tel;
    @Column(name = "type")
    private Boolean type;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "addTime", columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate addTime;
    @Column(name = "dateFrom", columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;
    @Column(name = "dateTo",  columnDefinition = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;
    @Column(name = "note")
    private String note;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resource_id")
    private Resource resource;


    public Ticket() {
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDate addTime) {
        this.addTime = addTime;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                type == ticket.type &&
                active == ticket.active &&
                Objects.equals(firstName, ticket.firstName) &&
                Objects.equals(lastName, ticket.lastName) &&
                Objects.equals(email, ticket.email) &&
                Objects.equals(tel, ticket.tel) &&
                Objects.equals(addTime, ticket.addTime) &&
                Objects.equals(dateFrom, ticket.dateFrom) &&
                Objects.equals(dateTo, ticket.dateTo) &&
                Objects.equals(note, ticket.note) &&
                Objects.equals(user, ticket.user) &&
                Objects.equals(owner, ticket.owner) &&
                Objects.equals(resource, ticket.resource);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, email, tel, type, active, addTime, dateFrom, dateTo, note, user, owner, resource);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                ", active=" + active +
                ", addTime=" + addTime +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", owner=" + owner +
                ", resource=" + resource +
                '}';
    }
}
