package com.anime.AnimeAppApi.repository;

import com.anime.AnimeAppApi.jikan.model.full.Root;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface JikanAnimeFullRepository extends MongoRepository<Root, Long> {

}
