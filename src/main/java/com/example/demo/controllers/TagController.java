package com.example.demo.controllers;

import com.example.demo.models.Tag;
import com.example.demo.models.form.TagDTO;
import com.example.demo.repositores.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/create_tag")
    public String createTag(Model model) {
        model.addAttribute("form",new Tag());
        return "create_tag";
    }

    @PostMapping("/save_tag")
    public String saveTag(@ModelAttribute("form") Tag tag, BindingResult result) {
        tagRepository.save(tag);
        return "redirect:/";
    }
}
