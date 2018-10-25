package com.blak.model;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user2res")
public class UserResources {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Type", nullable = false)
    private int type;

    @Column(name = "State", nullable = false)
    private int state;

    @Column(name = "AddTime", nullable = false)
    private LocalDate addTime;

    @Column(name = "DelTime")
    private LocalDate delTime;

    @Column(name = "Priority")
    private Integer priority;

    @Column(name = "DateFrom")
    private LocalDate dateFrom;

    @Column(name = "DateTo")
    private LocalDate dateTo;

    @Column(name = "Note")
    private String note;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "UserID",nullable = false)
    private User user;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ResourceID", nullable = false)
    private Resource resource;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ParentID")
    private UserResources parentUserResources;

    @OneToMany(mappedBy = "parentUserResources")
    @Transient
    private List<UserResources> userResources;

    public UserResources() {
    }

    public UserResources(int type, int state, LocalDate addTime, User user, Resource resource) {
        this.type = type;
        this.state = state;
        this.addTime = addTime;
        this.user = user;
        this.resource = resource;
    }

    public UserResources(int type, int state, LocalDate addTime, LocalDate delTime, Integer priority, LocalDate dateFrom, LocalDate dateTo, String note, User user, Resource resource) {
        this.type = type;
        this.state = state;
        this.addTime = addTime;
        this.delTime = delTime;
        this.priority = priority;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.note = note;
        this.user = user;
        this.resource = resource;
        this.parentUserResources = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public UserResources getUserResources() {
        return parentUserResources;
    }

    public void setUserResources(UserResources parentUserResources) {
        this.parentUserResources = parentUserResources;
    }


    @Override
    public String toString() {
        return "UserResources{" +
                "id=" + id +
                ", type=" + type +
                ", state=" + state +
                ", addTime=" + addTime +
                ", delTime=" + delTime +
                ", priority=" + priority +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", resource=" + resource +
                ", parentUserResources=" + parentUserResources +
                '}';
    }
}
