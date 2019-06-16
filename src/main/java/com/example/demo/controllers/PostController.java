package com.example.demo.controllers;

import com.example.demo.models.FormData;
import com.example.demo.models.Post;
import com.example.demo.models.Tag;
import com.example.demo.repositores.PostRepository;
import com.example.demo.repositores.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.services.PostService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/")
    public String index() {
        //postService.loadPosts();
        return "index";
    }

    @GetMapping("/load")
    public String getData() {
        return "data";
    }

    @GetMapping("/new")
    public String loadNewForm(Post post) {
        return "new";
    }

    @PostMapping("/save")
    public String save(Post post, BindingResult result, Model model) {
        postRepository.save(post);


        return "index";
    }

    @PostMapping("/save/{id}")
    public String saveUpdate(@PathVariable int id, Post post, BindingResult result, Model model) throws Exception {
        post.setId(id);
        postRepository.save(post);

        return "index";
    }

    @GetMapping("/list")
    public String loadNewForm(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id, Post post,
                             BindingResult result, Model model) {

        Optional<Post> editPost =  postRepository.findById(id);
        model.addAttribute("post", editPost.get());
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Post post,
                             BindingResult result, Model model) {

        Optional<Post> editPost =  postRepository.findById(id);
        postRepository.delete(editPost.get());

        model.addAttribute("post", editPost.get());

        return "index";
    }


    @GetMapping("/add_tag")
    public String addTag(Model model) {

        List<Post> posts = (List<Post>) postRepository.findAll();
        List<Tag> tags = (List<Tag>) tagRepository.findAll();

        model.addAttribute("posts", posts);
        model.addAttribute("tags", tags);
        model.addAttribute("formData",  new FormData());
        return "add_tag";
    }

    @PostMapping("/save_post_tag")
    public String saveTagData(@ModelAttribute FormData formData, Model model) {

        Post editedPost = postRepository.findById(formData.getPost()).get();
        Tag newTag = tagRepository.findById(formData.getTag()).get();

        editedPost.getTags().add(newTag);

        postRepository.save(editedPost);
        return "index";
    }

}
