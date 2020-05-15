package ru.vorobyov.database.entity;

public class ReportCardData {

    private String nameLastName;
    private String position;
    private int workerId;

    public ReportCardData(String nameLastName, String position, int workerId) {
        this.nameLastName = nameLastName;
        this.position = position;
        this.workerId = workerId;
    }

    public String getNameLastName() {
        return nameLastName;
    }

    public void setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
