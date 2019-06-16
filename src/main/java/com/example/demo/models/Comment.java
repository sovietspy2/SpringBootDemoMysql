package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String text;
}
