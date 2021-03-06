package com.isaiev.entities;

import java.util.ArrayList;
import java.util.Date;

public class Course {

    protected String id;
    protected String name;
    protected String link;
    protected String photoUrl;
    protected String description;
    protected Date startDate;
    protected String level;
    private ArrayList<String> tracks;

    public ArrayList<String> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<String> tracks) {
        this.tracks = tracks;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Course{" +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", tracks='" + tracks + '\'' +
                '}';
    }

    public String toStringFull() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", level='" + level + '\'' +
                '}';
    }
}
