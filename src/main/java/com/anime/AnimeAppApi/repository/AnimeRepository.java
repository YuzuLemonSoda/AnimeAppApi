package com.anime.AnimeAppApi.repository;

import com.anime.AnimeAppApi.model.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


public interface AnimeRepository extends MongoRepository<Anime, String> {

    List<Anime> findByRanking(Long ranking);
    List<Anime> findByStatus(String status);

    List<Anime> findByTitle(String title);

}
