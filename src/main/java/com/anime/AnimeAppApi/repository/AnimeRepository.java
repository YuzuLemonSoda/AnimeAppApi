package com.anime.AnimeAppApi.repository;

import com.anime.AnimeAppApi.entity.Anime;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AnimeRepository extends CrudRepository<Anime, String> {

}
