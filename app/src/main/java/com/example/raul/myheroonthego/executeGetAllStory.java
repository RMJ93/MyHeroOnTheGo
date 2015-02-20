package com.example.raul.myheroonthego;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Raul on 2/19/2015.
 */
public class executeGetAllStory {

    public ArrayList<AllStories> GetAllStory() {
        String URL = "http://198.199.112.105:5000/getAllStory";
        ArrayList<AllStories> allstory = new ArrayList<AllStories>();
        GetRequest getrequest = new GetRequest();
        try {

            String rawStoryData = getrequest.request(URL);

           // JSONObject jsonObject = new JSONObject(rawStoryData);

            JSONArray allstroyArray = rawStory.getJSONArray("");

            for (int i =0; i < allstroyArray.length(); i++) {

                AllStories story = new AllStories();

                JSONObject jsonStory = allstroyArray.getJSONObject(i);

                String tag = jsonStory.getString("tag");
                story.setTag(tag);

                String type = jsonStory.getString("type");
                story.setType(type);

                String description = jsonStory.getString("description");
                story.setDescription(description);

                allstory.add(story);
            }

        }

        catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return allstory;
    }

}
