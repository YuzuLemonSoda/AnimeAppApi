package com.anime.AnimeAppApi.controller;

import com.anime.AnimeAppApi.jikan.model.full.Root;
import com.anime.AnimeAppApi.repository.JikanAnimeFullRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/JikanAnimeFullCollection")
public class JikanAnimeFullController {

    @Autowired
    private JikanAnimeFullRepository jafRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/animeTop5")
    public ResponseEntity<List<Root>> getAnimeTop5() {

        return new ResponseEntity<>(jafRepo.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Root> getAnimeById(@PathVariable("id") long id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("data.mal_id").is(id));
        Root animeByMalId = mongoTemplate.findOne(query, Root.class);
        return new ResponseEntity<>(animeByMalId, HttpStatus.OK);

    }


}
