package com.samar.technology.LivesTracker.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="friend")
public class Friend {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String placeOfMeet;

    @Column(nullable = false)
    private String residentialLocation;
    @Column(nullable = false)
    private int salary;
    @Column(nullable = false)
    private long givenMoney;
    @Column(nullable = false)
    private long takenMoney;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;


    public Friend(){}

    public Friend(Long id, String name, String type, String placeOfMeet, String residentialLocation, int salary, long givenMoney, long takenMoney) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.placeOfMeet = placeOfMeet;
        this.residentialLocation = residentialLocation;
        this.salary = salary;
        this.givenMoney = givenMoney;
        this.takenMoney = takenMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaceOfMeet() {
        return placeOfMeet;
    }

    public void setPlaceOfMeet(String placeOfMeet) {
        this.placeOfMeet = placeOfMeet;
    }

    public String getResidentialLocation() {
        return residentialLocation;
    }

    public void setResidentialLocation(String residentialLocation) {
        this.residentialLocation = residentialLocation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getGivenMoney() {
        return givenMoney;
    }

    public void setGivenMoney(long givenMoney) {
        this.givenMoney = givenMoney;
    }

    public long getTakenMoney() {
        return takenMoney;
    }

    public void setTakenMoney(long takenMoney) {
        this.takenMoney = takenMoney;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", placeOfMeet='" + placeOfMeet + '\'' +
                ", residentialLocation='" + residentialLocation + '\'' +
                ", salary=" + salary +
                ", givenMoney=" + givenMoney +
                ", takenMoney=" + takenMoney +
                '}';
    }
}
