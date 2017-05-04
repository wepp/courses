package com.isaiev.entities;

import java.util.Date;

/**
 * Created by Isaiev on 03.05.2017.
 */
public class CourseraCourse extends Course {

    @Override
    public void setLink(String link) {
        this.link = "https://ru.coursera.org/learn/"+link;
    }
}
