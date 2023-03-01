package com.anime.AnimeAppApi.controller;

import com.anime.AnimeAppApi.model.Manga;
import com.anime.AnimeAppApi.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/mangaCollection")
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/manga")
    public ResponseEntity<List<Manga>> getAllManga() {

        List<Manga> mangaList = new ArrayList<Manga>();

        mangaRepository.findAll().forEach(mangaList::add);

        return new ResponseEntity<>(mangaList, HttpStatus.OK);

    }


}
