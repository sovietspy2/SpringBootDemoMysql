package com.example.demo.models;

import com.example.demo.models.form.TagDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag {

    public Tag() {

    }

    public Tag(TagDTO tagDTO) {
        this.tag = tagDTO.getTagName();
    }


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
