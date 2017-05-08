package com.isaiev.controllers;

import com.isaiev.entities.Course;
import com.isaiev.entities.SearchQuery;
import com.isaiev.services.ICourseraService;
import com.isaiev.services.impl.EdxService;
import com.isaiev.services.impl.UdacityService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Isaiev on 02.05.2017.
 */
@Controller
public class MainController {

    @Autowired
    ICourseraService courseraService;
    @Autowired
    UdacityService udacityService;
    @Autowired
    EdxService edxService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("queryJsp", new SearchQuery(""));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value="/search")
    public ModelAndView searchCourses (@ModelAttribute("query") SearchQuery query) throws JSONException {
        System.out.println("query="+query.getQuery());
        ArrayList<Course> courses = courseraService.getByQuery(query.getQuery());
        courses.addAll(udacityService.getByQuery(query.getQuery()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses", courses);
        modelAndView.setViewName("resultPage");
        return modelAndView;
    }

    @RequestMapping(value = "/udacity", method = RequestMethod.GET)
    public ModelAndView udacity() {
        ArrayList<Course> courses = udacityService.getAllCourses();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("queryJsp", new SearchQuery(""));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/edx", method = RequestMethod.GET)
    public ModelAndView edx() {
        edxService.getAllCourses ();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("queryJsp", new SearchQuery(""));
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
