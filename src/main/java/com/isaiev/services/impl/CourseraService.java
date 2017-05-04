package com.isaiev.services.impl;

import com.isaiev.entities.Course;
import com.isaiev.parsers.CourseraJsonParser;
import com.isaiev.parsers.JsonParser;
import com.isaiev.services.ICourseraService;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;

/**
 * Created by Isaiev on 02.05.2017.
 */
@Service
public class CourseraService implements ICourseraService {

    private JsonParser parser = new CourseraJsonParser();

    public ArrayList<Course> getByQuery (String query) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        query = query.replaceAll(" ","+");
        String result = restTemplate.getForObject("https://api.coursera.org/api/courses.v1?q=search&query="
                +query+ "&fields=id,name,slug,photoUrl,startDate,previewLink,description", String.class);
        System.out.println(result.length());
        ArrayList<Course> courses = parser.parseJson(result);
        System.out.println(courses);
        return courses;
    }
}
