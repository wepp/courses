package com.isaiev.services;

import com.isaiev.entities.Course;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Isaiev on 02.05.2017.
 */
public interface ICourseraService {
    ArrayList<Course> getByQuery (String query) throws JSONException;
}
