package ru.vorobyov.database.entity;

import javafx.scene.image.Image;

import java.sql.Date;

public class WorkersData {
    private String name;
    private String lastName;
    private Date birthday;
    private int age;
    private String position;
    private Boolean remoteWork;
    private String address;

    public WorkersData(String name, String lastName, Date birthday, int age, String position, Boolean remoteWork, String address) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.age = age;
        this.position = position;
        this.remoteWork = remoteWork;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getRemoteWork() {
        return remoteWork;
    }

    public void setRemoteWork(Boolean remoteWork) {
        this.remoteWork = remoteWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
