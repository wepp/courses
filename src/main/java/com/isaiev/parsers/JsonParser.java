package com.isaiev.parsers;

import com.isaiev.entities.Course;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Isaiev on 03.05.2017.
 */
public abstract class JsonParser {


    public ArrayList<Course> parseJson (String source) {
        ArrayList<Course> courses = null;
        JSONObject obj = null;
        try {
            obj = new JSONObject(source);
            JSONArray arr = obj.getJSONArray(getTag());
            courses = new ArrayList<Course>(arr.length());
            for (int i = 0; i < arr.length(); i++){
                courses.add(mapJsonToObject(arr.getJSONObject(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    protected abstract Course mapJsonToObject(JSONObject courseJson) throws JSONException;

    protected abstract String getTag();
}
