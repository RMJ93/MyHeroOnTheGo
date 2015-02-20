package com.example.raul.myheroonthego;

import java.io.Serializable;

/**
 * Story object
 * Created by Raul on 2/19/2015.
 */
public class AllStories implements Serializable {

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    private String tag;
    private String type;
    private String description;
    /**
     * Return a String representation of our Plant.
     */
    @Override
    public String toString() {
// TODO Auto-generated method stub
        return tag + " " + type + " " + description;
    }


}
