package com.isaiev.parsers;

import com.isaiev.entities.Course;
import com.isaiev.entities.CourseraCourse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Isaiev on 02.05.2017.
 */
public class CourseraJsonParser extends JsonParser{

    @Override
    protected Course mapJsonToObject(JSONObject courseJson) throws JSONException {
        CourseraCourse course = new CourseraCourse();
        course.setId(courseJson.getString("id"));
        course.setName(courseJson.getString("name"));
        course.setPhotoUrl(courseJson.isNull("photoUrl") ?
                null : courseJson.getString("photoUrl"));
        course.setDescription(courseJson.getString("description"));
        course.setLink(courseJson.getString("slug"));
        course.setStartDate(courseJson.isNull("startDate") ?
                null : new Date(Long.parseLong(courseJson.getString("startDate"))));
        System.out.println(course.getLink());
        return course;
    }

    @Override
    protected String getTag() {
        return "elements";
    }
}
