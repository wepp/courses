package com.isaiev.search;

import com.isaiev.entities.Course;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Isaiev on 07.05.2017.
 */
public class UdacitySearch {

    public ArrayList<Course> searchCourses(String query, ArrayList<Course> courses){
        System.out.println("START SEARCH");
        ArrayList<Course> result = new ArrayList<Course>();
        ArrayList<String> words = splitQuery(query);
        for(Course course: courses){
            if (isCourseMatchesQuery(course, words)){
                result.add(course);
            }
        }
        System.out.println("found: "+result);
        System.out.println("END SEARCH");
        return result;
    }

    private boolean isCourseMatchesQuery (Course course, ArrayList<String> words){
        for(String word : words){
            if (containsIgnoreCase(course.getName(), word)){
                return true;
            }
            ArrayList<String> tracks = course.getTracks();
            if(tracks!=null){
                if(tracks.contains(word.toLowerCase())){
                    System.out.println("found by tracks: "+course.getName());
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsIgnoreCase(String str, String searchStr)     {
        if(str == null || searchStr == null) return false;

        final int length = searchStr.length();
        if (length == 0)
            return true;

        for (int i = str.length() - length; i >= 0; i--) {
            if (str.regionMatches(true, i, searchStr, 0, length))
                return true;
        }
        return false;
    }

    private ArrayList<String> splitQuery (String query){
        System.out.println("query = "+query);
        ArrayList<String> result = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(query,":/.-,'\" ");
        while (st.hasMoreElements()) {
            result.add(st.nextElement().toString());
        }
        System.out.println("splitted words = "+result);
        return result;
    }
}
