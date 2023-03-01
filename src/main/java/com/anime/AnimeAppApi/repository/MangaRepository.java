package com.anime.AnimeAppApi.repository;

import com.anime.AnimeAppApi.model.Manga;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MangaRepository extends MongoRepository<Manga, Long> {

}
