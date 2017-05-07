package com.isaiev.parsers;

import com.isaiev.entities.Course;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Isaiev on 03.05.2017.
 */
public class UdacityParser extends JsonParser{

    protected Course mapJsonToObject(JSONObject courseJson) throws JSONException {
        Course course = new Course();
        course.setId(courseJson.getString("key"));
        course.setName(courseJson.getString("title"));
        course.setPhotoUrl(courseJson.isNull("image") ?
                null : courseJson.getString("image"));
        course.setDescription(courseJson.getString("summary"));
        course.setLink(courseJson.getString("homepage"));
        JSONArray arr = courseJson.getJSONArray("tracks");
        ArrayList<String> tracks = new ArrayList<String>(arr.length());
        for (int i = 0; i < arr.length(); i++){
            tracks.add(arr.getString(i).toLowerCase());
        }
        course.setTracks(tracks);
        return course;
    }

    @Override
    protected String getTag() {
        return "courses";
    }
}
