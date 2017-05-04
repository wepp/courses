package com.isaiev.services.impl;

import com.isaiev.entities.Course;
import com.isaiev.parsers.JsonParser;
import com.isaiev.parsers.UdacityParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Isaiev on 03.05.2017.
 */

@Service
public class UdacityService {

    private JsonParser parser = new UdacityParser();

    public ArrayList<Course> getAllCourses ()  {
        RestTemplate restTemplate = new RestTemplate();
        String result = readFile ("D:/udacityJson.txt", Charset.defaultCharset());
        //String result = restTemplate.getForObject("https://www.udacity.com/public-api/v0/courses", String.class);
        ArrayList<Course> courses = parser.parseJson(result);
        System.out.println("courses.size() = "+courses.size());
        return courses;
    }

    private String readFile(String path, Charset encoding)
    {
        System.out.println("start read");
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end read");
        return new String(encoded, encoding);
    }
}
