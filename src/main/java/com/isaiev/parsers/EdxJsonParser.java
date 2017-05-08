package com.isaiev.parsers;

import com.isaiev.entities.Course;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Isaiev on 08.05.2017.
 */
public class EdxJsonParser extends JsonParser{

    @Override
    protected Course mapJsonToObject(JSONObject courseJson) throws JSONException {
        return null;
    }

    @Override
    protected String getTag() {
        return null;
    }

    public String parseAccessToken (String json){
        System.out.println("json = "+json);
        String token = null;
        try {
            JSONObject obj = new JSONObject(json);
            token = obj.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("token = "+token);
        return token;
    }
}
