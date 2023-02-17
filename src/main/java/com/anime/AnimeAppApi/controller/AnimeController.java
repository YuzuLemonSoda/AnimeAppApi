package com.anime.AnimeAppApi.controller;

import com.anime.AnimeAppApi.entity.Anime;
import com.anime.AnimeAppApi.service.AnimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/anime")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/list")
    public Iterable<Anime> list() {
        return animeService.list();
    }

}
