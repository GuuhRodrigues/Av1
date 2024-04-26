package com.example.Av1.controller;

import com.example.Av1.model.NewsEntity;
import com.example.Av1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private NewsService newsService;

    @GetMapping("/noticiasereleases")
    public String obterTodos() {
        return newsService.obterTodos();
    }

    @GetMapping("/noticias")
    public String obterNoticias() {
        return newsService.obterNoticias();
    }

    @GetMapping("/releases")
    public String obterReleases() {
        return newsService.obterReleases();
    }
}
