package com.example.kino.controllers;
import com.example.kino.models.Post;
import com.example.kino.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KinoController {
    @Autowired
    private PostRepository PostRepository;
    @GetMapping("/kino_main")
    public String kinoMain(Model model) {
        Iterable<Post> posts = PostRepository.findAll();
        model.addAttribute("posts", posts);
        return "kino_main";
    }
}
