package com.anime.AnimeAppApi.service;

import com.anime.AnimeAppApi.entity.Anime;
import com.anime.AnimeAppApi.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Iterable<Anime> list() {
        return animeRepository.findAll();
    }


    public Iterable<Anime> save(List<Anime> animeList) {
        return animeRepository.saveAll(animeList);
    }

}
