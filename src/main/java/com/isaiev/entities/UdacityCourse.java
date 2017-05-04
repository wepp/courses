package com.isaiev.entities;

import java.util.ArrayList;

/**
 * Created by Isaiev on 03.05.2017.
 */
public class UdacityCourse extends Course {

    private ArrayList<String> tracks;

    public ArrayList<String> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toStringFull() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", level='" + level + '\'' +
                ", tracks='" + tracks + '\'' +
                '}';
    }
}
