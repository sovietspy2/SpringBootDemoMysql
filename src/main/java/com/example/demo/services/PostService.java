package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositores.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void loadPosts() {
         //dummy
    }

}
