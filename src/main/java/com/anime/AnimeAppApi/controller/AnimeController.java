package com.anime.AnimeAppApi.controller;

import com.anime.AnimeAppApi.model.Anime;
import com.anime.AnimeAppApi.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/animeCollection")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/anime")
    public ResponseEntity<List<Anime>> getAllAnime(@RequestParam(required = false) String title) {
        try {
            List<Anime> animeList = new ArrayList<Anime>();

            if (title == null) {
                animeRepository.findAll().forEach(animeList::add);
            } else {
                animeRepository.findByTitle(title).forEach(animeList::add);
            }

            if (animeList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(animeList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable("id") String id) {

        Optional<Anime> animeData = animeRepository.findById(id);

        if(animeData.isPresent()) {
            return new ResponseEntity<>(animeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/anime/ranking")
//    public ResponseEntity<Anime> getAnimeByRanking(@)


//    private final AnimeService animeService;

//    public AnimeController(AnimeService animeService) {
//        this.animeService = animeService;
//    }

//    @GetMapping("/list")
//    public Iterable<Anime> list() {
//        return animeService.list();
//    }



}
