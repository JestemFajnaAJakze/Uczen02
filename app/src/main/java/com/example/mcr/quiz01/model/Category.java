package com.example.mcr.quiz01.model;
        import com.j256.ormlite.field.DatabaseField;
        import com.j256.ormlite.table.DatabaseTable;
/**
 * Created by MCR on 02.09.2016.
 */

public class Category {


    private long id;


    private String name;

    private int imageResourceId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

}