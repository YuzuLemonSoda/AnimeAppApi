package com.anime.AnimeAppApi.repository;

import com.anime.AnimeAppApi.jikan.model.seasonNow.Root;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JikanAnimeSeasonNowRepository extends MongoRepository<Root, Long> {

}
