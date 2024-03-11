package com.example.kino.controllers;
import com.example.kino.models.Post;
import com.example.kino.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class KinoController {
    @Autowired
    private PostRepository PostRepository;
    @GetMapping("/kino")
    public String kinoMain(Model model) {
        Iterable<Post> posts = PostRepository.findAll();
        model.addAttribute("posts", posts);
        return "kino-main";
    }
    @GetMapping("/kino/add")
    public String kinoAdd(Model model) {
        return "kino-add";
    }
    @PostMapping("kino/add")
    public String kinoPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        PostRepository.save(post);
        return "redirect:/kino";
    }
    @GetMapping("/kino/{id}")
    public String kinoDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> post = PostRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "kino-details";
    }

    @GetMapping("/kino/{id}/edit")
    public String kinoEdit(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> post = PostRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "kino-edit";
    }
}
