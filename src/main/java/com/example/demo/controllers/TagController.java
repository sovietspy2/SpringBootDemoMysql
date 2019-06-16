package com.example.demo.controllers;

import com.example.demo.models.Tag;
import com.example.demo.models.TagDTO;
import com.example.demo.repositores.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.HTML;

@Controller
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/create_tag")
    public String createTag(Model model) {
        model.addAttribute("tag",new TagDTO());
        return "create_tag";
    }

    @PostMapping("/save_tag")
    public String saveTag(@ModelAttribute TagDTO tag) {
        tagRepository.save(new Tag(tag));
        return "index";
    }
}
