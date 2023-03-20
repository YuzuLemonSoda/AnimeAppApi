package com.anime.AnimeAppApi.controller;

import com.anime.AnimeAppApi.jikan.model.seasonNow.Root;
import com.anime.AnimeAppApi.repository.JikanAnimeSeasonNowRepository;
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
@RequestMapping("/JASNCollection")
public class JikanAnimeSeasonNowController {

    @Autowired
    private JikanAnimeSeasonNowRepository jasnRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/seasonNow/")
    public ResponseEntity<Root> getAnimeSeasonNowByPage(@RequestParam(value = "current_page", defaultValue = "1") int current_page) {

        Query query = new Query();
        query.addCriteria(Criteria.where("pagination.current_page").is(current_page));
        Root seasonNowPage = mongoTemplate.findOne(query, Root.class);
        return new ResponseEntity<>(seasonNowPage, HttpStatus.OK);
    }


}
